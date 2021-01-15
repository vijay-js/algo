package Graph.traversals.questions;

import Graph.GraphImpl;
import Graph.Vertex;

import java.util.*;

//Every distance can be calculated from prev distance in bfs

public class ShortestPathInUnweightedGraph {

    public static int[] shortestDistanceFromSource(GraphImpl graph, Vertex src) {
        int numVertices = graph.vertices.size();

        boolean visisted[] = new boolean[numVertices];
        int dist[] = new int[numVertices];

        for(int i=0;i<numVertices;i++) {
            dist[i] = Integer.MAX_VALUE;
        }



        Queue<Vertex> queue = new LinkedList<>();
        queue.add(src);
        dist[graph.getVertexIndex(src)] = 0;
        visisted[graph.getVertexIndex(src)] = true;


        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            int idx = graph.getVertexIndex(v);
            List<Integer> list = graph.adjacencyList.get(idx);

            for(int i: list) {
                if(visisted[i] !=true) {
                    dist[i] = dist[idx] + 1;
                    queue.add(graph.getVertex(i));
                    visisted[i] = true;
                }

            }

        }


        for(int i=0;i<numVertices;i++) {
            System.out.println(graph.getVertex(i).name + " -> " + dist[i]);
        }

        return dist;
    }

    public static Map<Vertex,Integer>  shortestPath(GraphImpl graph, Vertex src) {

        Queue<Vertex> queue = new LinkedList<>();
        List<List<Integer>> adjacencyList = graph.adjacencyList;



        Map<Vertex,Integer> map = new HashMap<>();
        boolean[]visited = new boolean[graph.vertices.size()];

        queue.add(src);
        visited[graph.getVertexIndex(src)] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Vertex v = queue.poll();
                int idx = graph.getVertexIndex(v);
                map.put(v,level);

                List<Integer> list = adjacencyList.get(idx);
                for(int j: list )  {
                    if(visited[j]!=true) {
                        visited[j] = true;
                        queue.add(graph.getVertex(j));
                    }
                }
            }
            level++;
        }

        for(Map.Entry<Vertex,Integer>m : map.entrySet()) {
            System.out.println(m.getKey().name + " -> " + m.getValue());
        }
        System.out.println();
        return  map;
    }
}
