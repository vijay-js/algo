package Graph.cycleDetection;


import Graph.GraphImpl;
import Graph.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CycleInUndirectedGraphUsingBFS {

    public static boolean isCyclicGraph(GraphImpl graph) {

        int numVertices = graph.vertices.size();
        boolean[] visited = new boolean[numVertices];


        for(int i=0;i<numVertices;i++) {
            if(visited[i] == false) {
                if(detectCycle(graph,graph.getVertex(i),visited)) return true;
            }
        }
        return false;
    }

    private static boolean detectCycle(GraphImpl graph, Vertex src ,boolean[] visited) {

        Queue<Vertex> queue = new LinkedList<>();

        queue.add(src);
        visited[graph.getVertexIndex(src)] = true;

        Vertex parent = null;
        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int j=0;j<size;j++) {
                Vertex v = queue.poll();
                int idx = graph.getVertexIndex(v);
                List<Integer> list = graph.adjacencyList.get(idx);

                for(int i: list) {
                    if(visited[i] == true ) {
                        //Check if its not parent
                        Vertex visitedVertex = graph.getVertex(i);
                        if(visitedVertex.name.equals(parent.name)) {
                            //ignore
                            continue;
                        }
                        return true;
                    }
                    else {
                        parent = v;
                        queue.add(graph.getVertex(i));
                        visited[i] = true;
                    }
                }
            }

        }

        return false;
    }

    private static boolean dfsDetectCycle(GraphImpl graph, Vertex v, Vertex parent, boolean[] visited) {
        int idx = graph.getVertexIndex(v);
        System.out.println("Processing node " + v.name);
        visited[idx] = true;

        List<Integer> list = graph.adjacencyList.get(idx);

        for(int i: list) {
            System.out.println("Processing  index " + i +" of list of vertex " + v.name);
            if(visited[i] == false) {
                if(dfsDetectCycle(graph,graph.getVertex(i),v,visited) )return true;
            }
            else {
                int parentIndex = graph.getVertexIndex(parent);
                if(i != parentIndex) {
                    return true;
                }
            }
        }
        return false;
    }
}
