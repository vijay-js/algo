package Graph;

public class Edge {
    Vertex source;
    Vertex destination;
    int weight;

    Edge(Vertex src, Vertex dest) {
        this.source = src;
        this.destination = dest;
        this.weight = 0;
    }
}
