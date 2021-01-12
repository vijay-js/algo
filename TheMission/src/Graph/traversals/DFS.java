package Graph.traversals;

import Graph.GraphImpl;
import Graph.Vertex;


public class DFS {

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
