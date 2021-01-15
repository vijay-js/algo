package Graph.traversals;

import Graph.GraphImpl;
import Graph.Vertex;

import java.util.List;
import java.util.Stack;


public class DFS {


    public static void dfs1(GraphImpl graph, Vertex src, boolean[] visited) {

        int idx = graph.getVertexIndex(src);
        visited[idx] = true;

        List<Integer> list = graph.adjacencyList.get(idx);

        for(int i :list) {
            if(visited[i] == false) {
                dfs1(graph,graph.getVertex(i),visited);
            }
        }

    }

    public static void dfsUsingStack(GraphImpl graph, Vertex src) {
        int numVertices = graph.vertices.size();
        boolean[] visited = new boolean[numVertices];
        int idx = graph.getVertexIndex(src);

        Stack<Vertex> stack = new Stack<>();
        stack.push(src);
        visited[idx] = true;

        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            int id = graph.getVertexIndex(v);

            List<Integer> list = graph.adjacencyList.get(id);

            for(int i: list) {
                if(visited[i] == false) {
                    Vertex vertex  = graph.getVertex(i);
                    stack.push(vertex);
                    visited[i] = true;
                }
            }

        }

    }

    public static void printDFS(GraphImpl graph, Vertex src, boolean[]visited ) {

        int idx = graph.getVertexIndex(src);
        if(visited[idx] !=true) {
            System.out.print(src.name + " ");
            visited[idx] = true;

            for(int i=0;i<graph.adjacencyList.get(idx).size();i++) {
                int vertexIndex = graph.adjacencyList.get(idx).get(i);
                Vertex v = graph.getVertex(vertexIndex);
                printDFS(graph,v ,visited);
            }

        }

    }
}
