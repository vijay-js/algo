package Graph.topologicalSorting;

import Graph.GraphImpl;
import Graph.Vertex;

import java.util.List;
import java.util.Stack;

public class DFSBasedTopologicalSort {
    public static void dfsSort(GraphImpl graph, Vertex v, boolean[] visited, Stack<Vertex> stack) {
        int idx = graph.getVertexIndex(v);

        visited[idx] = true;

        List<Integer>  list = graph.adjacencyList.get(idx);

        for(int i:list) {
            if(visited[i] == false) {
                dfsSort(graph,graph.getVertex(i),visited,stack);
            }
        }

        stack.push(v);
    }

    private static void printStack(Stack<Vertex> stack) {
        for(Vertex v: stack) {
            System.out.print(v.name + " ");
        }
    }
}
