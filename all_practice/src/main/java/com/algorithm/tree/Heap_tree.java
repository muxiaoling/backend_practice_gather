package com.algorithm.tree;

import java.util.Arrays;

//小顶堆
public class Heap_tree {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        up(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {7,1,3,10,5,2,8,9,6};
        build_heap(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 上浮操作
     * @param arr 待调整的堆
     */
    public static void up (int[] arr) {
        int children = arr.length - 1;
        int parent = (children - 1) / 2;

        int temp = arr[children];
        while (children > 0 && temp < arr[parent]) {
            arr[children] = arr[parent];
            children = parent;
            parent = (children - 1) / 2;
        }
        arr[children] = temp;
    }

    /**
     * 下沉操作
     * @param arr 待排序数组
     * @param parent  非叶子父节点下标
     */
    public static void down (int[] arr, int parent) {
        int temp = arr[parent];
        int children = 2 * parent + 1;
        while (children < arr.length) {
            if (children + 1 < arr.length && arr[children + 1] < arr[children]) {
                children++;
            }

            if (temp < arr[children]) {
                break;
            }
            arr[parent] = arr[children];
            parent = children;
            children = 2 * parent + 1;
        }

        arr[parent] = temp;
    }

    /**
     * 创建堆
     * @param arr 待排序数组
     */
    public static void build_heap (int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            down(arr, i);
        }
    }
}
