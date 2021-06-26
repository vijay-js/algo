package BSTLearn.traversals.tricky;

import BSTLearn.Node;

import java.util.List;

public class PrintNodesAtKDistanceFromLeaves {
    public static void main(String[] args) {

    }
//visited is to not print the same element twice
    public static void print(Node head, int k, List<Integer> path, List<Boolean> visited) {

        if(head == null) return;

        path.add(head.val);
        visited.add(false);
        if(head.left == null && head.right == null) {
            if(!visited.get(path.size()-k)) {

                int el = path.get(path.size() - k);
                System.out.print(el + " ");
                visited.set(path.size()-k,true);
            }

        }

        print(head.left,k,path,visited);
        print(head.right,k,path,visited);

        path.remove(path.size()-1);
        visited.remove(visited.size() -1);
    }
}

