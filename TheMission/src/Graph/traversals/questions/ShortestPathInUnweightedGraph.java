package Graph.traversals.questions;

import Graph.GraphImpl;
import Graph.Vertex;

import java.util.*;


public class ShortestPathInUnweightedGraph {

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
