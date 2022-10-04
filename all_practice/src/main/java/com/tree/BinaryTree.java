package com.tree;

import java.util.*;

public class BinaryTree {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node1 = new TreeNode(1, node3, node4);
        TreeNode root = new TreeNode(0, node1, node2);

        List<List<Integer>> result = levelOrder(root);
        for (List<Integer> list : result) {
//            for (Integer val : list) {
//                System.out.println(val + " ");
//            }
            System.out.println(list);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deq = new ArrayDeque<>();
        deq.offerLast(root);
        while (!deq.isEmpty()) {
            int size = deq.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deq.pollFirst();
                list.add(node.val);
                if (node.left != null) deq.offerLast(node.left);
                if (node.right != null) deq.offerLast(node.right);
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}


