package DisjointSet;

public class DisjointSet {

    int totalElements;
    //Ideally this parent array points to the objects of an element like a Friend Object in a social network
    //We should have way to map each object to a disctinct index in the array.
    int [] parent = new int[totalElements];

    int [] rank = new int[totalElements];

    public DisjointSet(int [] set) {
        this.totalElements= set.length;
        //set parent of each as itself
        for(int i=0;i<set.length;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }



    public int find(int el) {
        if(parent[el] == el) return el;
        return find(parent[el]);
    }

    public void Union(int el1, int el2) {

        //Also gives the size
        int p1 = find(el1);
        int p2 = find(el2);

        if(rank[el1] > rank[el2]) {
            
        }

        if(el1 != el2) {
            parent[p2] = p1;
        }

    }



}
