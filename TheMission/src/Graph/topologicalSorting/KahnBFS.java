package Graph.topologicalSorting;

import Graph.GraphImpl;
import Graph.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnBFS {
    public static void topologicalSort(GraphImpl graph) {
        int numVertices = graph.vertices.size();
        //Create indegree matrix
        int indegree[] = new int[numVertices];

        //Fill the indegree matrix by traversing the adjacency list

        for(int i=0;i<numVertices;i++) {
            List<Integer> list = graph.adjacencyList.get(i);
            for(int j : list) {
                indegree[j] = indegree[j] ++;
            }
        }

        Queue<Vertex> queue = new LinkedList<>();

        for(int i=0;i<numVertices;i++) {
            if(indegree[i] == 0) queue.add(graph.getVertex(i));
        }


        while (!queue.isEmpty()) {

            Vertex vertex = queue.poll();
            int idx = graph.getVertexIndex(vertex);

            System.out.print(vertex.name + " ");

            List<Integer> list = graph.adjacencyList.get(idx);

            for(int i: list) {
                indegree[i] = indegree[i] -1;
                if(indegree[i] == 0) {
                    queue.add(graph.getVertex(i));
                }
            }

        }

        //If all vertices are processed -> Cool
    }
}
