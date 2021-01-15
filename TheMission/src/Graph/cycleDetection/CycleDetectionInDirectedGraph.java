package Graph.cycleDetection;

import Graph.Edge;
import Graph.GraphImpl;
import Graph.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CycleDetectionInDirectedGraph {

    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl();
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
//        Vertex v5 = new Vertex("E");

        graph.addVertex(v1).addVertex(v2).addVertex(v3).addVertex(v4);

        Edge e1 = new Edge(v1,v2);
        Edge e2 = new Edge(v2,v3);
        Edge e3 = new Edge(v3,v4);
        Edge e4 = new Edge(v4,v2);


        graph.addDirectedEdge(e1).addDirectedEdge(e2).addDirectedEdge(e3).addDirectedEdge(e4);

        System.out.println(detectCycle(graph));
    }

    public static boolean detectCycle(GraphImpl graph) {

        int numVertices = graph.vertices.size();

        boolean[] visited = new boolean[numVertices];
        boolean recArray[] = new boolean[graph.vertices.size()];

        //This is for non connected graphs
        for(int i=0;i<numVertices;i++) {
            if(visited[i] == false) {
                if(cycle(graph,graph.getVertex(i),visited,recArray) == true) return true;
            }
        }
        return false;
    }

    private static boolean cycleExists(GraphImpl graph, Vertex v , boolean [] visited, Set<Vertex> set)  {

        int idx = graph.getVertexIndex(v);
        visited[idx] = true;
        set.add(v);

        List<Integer> list = graph.adjacencyList.get(idx);

        for(int i: list) {
            Vertex vertex = graph.getVertex(i);
            if(visited[i] == false && cycleExists(graph,vertex,visited,set)) {
                        return true;
            }
            else if(set.contains(vertex)) {
                return true;
            }
        }
        set.remove(v);
        return false;


    }

    private static boolean cycle(GraphImpl graph, Vertex v, boolean[] visited, boolean[] recArray) {

        int idx = graph.getVertexIndex(v);
        recArray[idx] = true;
        visited[idx] = true;

        List<Integer> list = graph.adjacencyList.get(idx);

        for(int i: list) {
            if(visited[i] ==false && cycle(graph,graph.getVertex(i),visited,recArray)) {
               return true;
            }
            else if (recArray[i] == true) {
                return true;
            }
        }
        recArray[idx] = false;
        return false;
    }


    private static boolean detectCycle(GraphImpl graph, Vertex v, boolean[] visited, Set<Vertex> set) {
        int idx = graph.getVertexIndex(v);
        visited[idx] = true;
        set.add(v);

        List<Integer> list = graph.adjacencyList.get(idx);

        for(int i: list) {
            Vertex vertex = graph.getVertex(i);
            if(visited[i] == false) {
                if(detectCycle(graph,vertex,visited,set)) return true;
            }
            else {
                if(set.contains(vertex)) return true;
            }
        }
        set.remove(v);
        return false;
    }


    private static boolean detectCycleBFS(GraphImpl graph) {
        //Fill indegree
        int numVertices = graph.vertices.size();

        int indegree[] = new int[numVertices];

        for(int i=0;i<numVertices;i++) {
            List<Integer> list = graph.adjacencyList.get(i);
            for(int j: list) {
                indegree[j] = indegree[j] + 1;
            }
        }

        Queue<Vertex> queue = new LinkedList<>();

        for(int i=0;i<numVertices;i++) {
            if(indegree[i] ==0) queue.add(graph.getVertex(i));
        }

        //Keep count of processed nodes.
        int processedNodes = 0;

        while(!queue.isEmpty()) {

            Vertex v = queue.poll();
            int idx = graph.getVertexIndex(v);

            List<Integer> list = graph.adjacencyList.get(idx);

            for(int j:list) {
                indegree[j] = indegree[j] -1;
                if(indegree[j] ==0) {
                    queue.add(graph.getVertex(j));
                }
            }

            processedNodes++;

        }

        return processedNodes == numVertices;
    }

}
