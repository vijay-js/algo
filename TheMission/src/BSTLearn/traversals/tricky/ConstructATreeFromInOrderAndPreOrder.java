package BSTLearn.traversals.tricky;

import BSTLearn.Node;

public class ConstructATreeFromInOrderAndPreOrder {
    public static void main(String[] args) {
        int in[] = {};
        int pre[] = {};

        Node root = constructTree(in,pre,0,pre.length-1);
    }


    private static Node constructTree(int in[], int pre[], int start,int end) {
////        if(start == end) {
////            return new Node(pre[start]);
////        }
//        Node root = new Node(pre[start]);
//        findIndex(pre[start],in);
//        root.left = constructTree(in,pre,)

        return new Node();
    }


}
