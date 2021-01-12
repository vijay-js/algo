package Graph.traversals;

import Graph.GraphImpl;
import Graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void printBFS(GraphImpl graph, Vertex src) {

        //Find number of vertices
        int vSize = graph.vertices.size();

        boolean [] visited = new boolean[vSize];

        Queue<Vertex> queue = new LinkedList<>();

        //find the index of the vertex

        visited[graph.getVertexIndex(src)] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            int idx = graph.getVertexIndex(v);
            System.out.print(v.name + " ");

            //go though the adjacency list of the popped vertex

            List<Integer> adjacencyList = graph.adjacencyList.get(idx);

            for(int i: adjacencyList) {
                if(visited[i] != true) {
                    queue.add(graph.getVertex(i));
                    visited[i] = true;
                }
            }
        }

    }

}
