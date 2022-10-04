package com.algorithm.graph.dijkstra;

import java.util.*;

//dijkstra算法
public class Dijkstra {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        initGraph(graph);
        Map<Integer, Integer> distanceMap = dijkstra(graph, 0);
        int distance = distanceMap.get(6);
        System.out.println(distance);
    }

    public static Map<Integer, Integer> dijkstra(Graph graph, int startIndex) {
        //创建距离表
        Map<Integer, Integer> distanceMap = new HashMap<>();
        //记录遍历过的顶点
        Set<Integer> visited = new HashSet<>();
        //图的顶点数
        int size = graph.vertices.length;
        //初始化最短路径表
        for (int i = 1; i < size; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        //遍历起点，刷新距离表
        visited.add(0);
        List<Edge> edgesFromStart = graph.adj[startIndex];
        for (Edge edge : edgesFromStart) {
            distanceMap.put(edge.index, edge.weight);
        }
        //主循环， 遍历最短距离顶点和刷新距离表
        for (int i = 1; i < size; i++) {
            //寻找最短距离顶点
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for (int j = 1; j < size; j++) {
                if (!visited.contains(j) && distanceMap.get(j) < minDistanceFromStart) {
                    minDistanceFromStart = distanceMap.get(j);
                    minDistanceIndex = j;
                }
            }
            if (minDistanceIndex == -1) break;
            //遍历顶点，刷新距离表
            visited.add(minDistanceIndex);
            for (Edge edge : graph.adj[minDistanceIndex]) {
                if (visited.contains(edge.index)) {
                    continue;
                }
                int weight = edge.weight;
                int preDistance = distanceMap.get(edge.index);
                if (weight != Integer.MAX_VALUE && (minDistanceFromStart + weight < preDistance)) {
                    distanceMap.put(edge.index, minDistanceFromStart + weight);
                }
            }
        }
        return distanceMap;
    }

    private static void initGraph(Graph graph) {
        graph.vertices[0] = new Vertex("A");
        graph.vertices[1] = new Vertex("B");
        graph.vertices[2] = new Vertex("C");
        graph.vertices[3] = new Vertex("D");
        graph.vertices[4] = new Vertex("E");
        graph.vertices[5] = new Vertex("F");
        graph.vertices[6] = new Vertex("G");

        graph.adj[0].add(new Edge(1, 5));
        graph.adj[0].add(new Edge(2, 2));
        graph.adj[1].add(new Edge(0, 5));
        graph.adj[1].add(new Edge(3, 1));
        graph.adj[1].add(new Edge(4, 6));

        graph.adj[2].add(new Edge(0, 2));
        graph.adj[2].add(new Edge(3, 6));
        graph.adj[2].add(new Edge(5, 8));

        graph.adj[3].add(new Edge(1, 1));
        graph.adj[3].add(new Edge(2, 6));
        graph.adj[3].add(new Edge(4, 1));
        graph.adj[3].add(new Edge(5, 2));

        graph.adj[4].add(new Edge(1, 6));
        graph.adj[4].add(new Edge(3, 1));
        graph.adj[4].add(new Edge(6, 7));

        graph.adj[5].add(new Edge(2, 8));
        graph.adj[5].add(new Edge(3, 2));
        graph.adj[5].add(new Edge(6, 3));

        graph.adj[6].add(new Edge(4, 7));
        graph.adj[6].add(new Edge(5, 3));

    }

    //图
    static class Graph {
        private Vertex[] vertices;
        private List<Edge>[] adj;
        public Graph(int size) {
            vertices = new Vertex[size];
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                adj[i] = new LinkedList<>();
            }
        }
    }
}

//边
class Edge {
    int index;
    int weight;
    public Edge (int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}

//顶点
class Vertex {
    String data;
    public Vertex(String data) {
        this.data = data;
    }
}

