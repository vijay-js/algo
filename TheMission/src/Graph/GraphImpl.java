package Graph;

import Graph.traversals.BFS;
import Graph.traversals.DFS;
import Graph.traversals.questions.ShortestPathInUnweightedGraph;

import java.util.ArrayList;
import java.util.List;



public class GraphImpl {

    public List<Vertex> vertices = new ArrayList<>();
    public List<List<Integer>> adjacencyList = new ArrayList<>();




    public GraphImpl addEdge(Edge e) {
        Vertex source = e.source;
        Vertex destination = e.destination;

        //First find the source and destination indices from the Vertices List
        int src = getVertexIndex(source);
        int dest = getVertexIndex(destination);

        //Traverse through adjacency list and add an edge for both src and dest since it's an undirected graph

        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src);

        return this;

    }

    public Vertex getVertex(int idx) {
        return vertices.get(idx);
    }

    public GraphImpl addVertex(Vertex v) {
        vertices.add(v);
        adjacencyList.add(getVertexIndex(v), new ArrayList<Integer>());
        return this;
    }

    //Given a vertex V find the index in the vertices list
    public int getVertexIndex(Vertex v) {
        for(int i=0;i<vertices.size();i++) {
            if(vertices.get(i).equals(v)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[]args){
        GraphImpl graph = new GraphImpl();
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        graph.addVertex(v1).addVertex(v2).addVertex(v3).addVertex(v4).addVertex(v5);

        Edge e1 = new Edge(v1,v2);
        Edge e2 = new Edge(v1,v3);
        Edge e3 = new Edge(v1,v5);
        Edge e4 = new Edge(v2,v3);
        Edge e5 = new Edge(v2,v4);
        Edge e6 = new Edge(v3,v4);
        Edge e7 = new Edge(v2,v5);
        Edge e8 = new Edge(v4,v5);

        graph.addEdge(e1).addEdge(e2).addEdge(e3).addEdge(e4).addEdge(e5).addEdge(e6).addEdge(e7).addEdge(e8);

//        BFS.printBFS(graph,v1);

        boolean visited [] = new boolean[graph.vertices.size()];
        System.out.println();
//        DFS.printDFS(graph,v1,visited);
        System.out.println();

        ShortestPathInUnweightedGraph.shortestPath(graph,v1);

    }

}
