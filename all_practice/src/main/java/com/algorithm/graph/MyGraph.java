package com.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MyGraph {
    private int size;
    private Vertex[] vertexes;
    private List<Integer>[] adj;
    MyGraph(int size) {
        this.size = size;
        vertexes = new Vertex[size];
        adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            vertexes[i] = new Vertex(i);
            adj[i] = new LinkedList<>();
        }
    }

    //深度优先遍历
    public static void dfs(MyGraph graph, int start, boolean[] visited) {
        System.out.print(graph.vertexes[start].date + " ");
        visited[start] = true;
        for (int index : graph.adj[start]) {
            if (!visited[index]) {
                dfs(graph, index, visited);
            }
        }
    }

    //广度优先遍历
    public static void bfs(MyGraph graph, int start, boolean[] visited, Deque<Integer> que) {
        que.offer(start);
        while (!que.isEmpty()) {
            int num = que.pollFirst();
            if (visited[num]) continue;
            System.out.print(graph.vertexes[num].date + " ");
            visited[num] = true;
            for (int index : graph.adj[num]) {
                que.offer(index);
            }
        }
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph(6);
        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);

        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);

        graph.adj[2].add(0);

        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);

        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);

        graph.adj[5].add(3);
        graph.adj[5].add(4);

        System.out.println("图的深度优先遍历：");
        dfs(graph, 0, new boolean[graph.size]);
        System.out.println("\n图的广度优先遍历：");
        bfs(graph, 0, new boolean[graph.size], new ArrayDeque<>());
    }

}

class Vertex {
    int date;
    public Vertex(int date) {
        this.date = date;
    }
}
