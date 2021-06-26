package BSTLearn.traversals.tricky;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

//The Key idea is to find the longest distant  node from this leaf node and that becomes the answer
public class CountTimeToBurnTreeFromLeafNodes {
    static int maxDistance =  Integer.MIN_VALUE;
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        Node head = bst.getHead();

        head.left = new Node(20);
        head.left.right = new Node(5);
        head.left.left = new Node(30);
        head.left.left.right = new Node(50);
        head.left.left.left = new Node(40);
        head.left.left.left.left = new Node(60);
        head.left.left.left.left.left = new Node(70);

        solve(head,50);
        System.out.println(maxDistance);
    }

    //x is the leaf node from where the burn happens
    public static int solve(Node head, int x) {
        if(head == null) return 0;

        //Check if  the current node is the starting leaf node to burn
        if(head.val == x) {
            return 1;
        }

        if(head.left == null && head.right == null) {
            return -1;
        }

        int lh = solve(head.left,x);
        int rh = solve(head.right,x);

        if(lh != -1) {
            //This subtree has the leaf node and this is one of the ancestors -> Now maxDistance would be the distance from this node
            //And distance of height of right subtree from this node
            int distanceFromLeaf = lh;
            int heightOfRightSubTree = findHeight(head.right);

            maxDistance = Math.max(maxDistance,distanceFromLeaf + heightOfRightSubTree);

        }

        if(rh != -1) {
            int distanceFromLeaf = rh;
            int heightOfLeftSubTree = findHeight(head.left);

            maxDistance = Math.max(maxDistance,distanceFromLeaf + heightOfLeftSubTree);
        }

        if(lh == -1 && rh ==-1) return  -1;

        return 1+ Math.max(lh,rh);

    }


    public static void PrintNodesAtKDistance(Node root, int k) {
        if(root == null) return;

        if(k ==0){
            System.out.print(root.val + " ");
            return;
        }
        if(k <0) return;

        PrintNodesAtKDistance(root.left,k-1);
        PrintNodesAtKDistance(root.right,k-1);

    }

    public static int findHeight(Node root) {
        if(root == null) return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return 1 + Math.max(lh,rh);
    }
}
