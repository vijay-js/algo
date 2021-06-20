package BSTLearn.traversals.tricky;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class CheckForBalancedBinaryTRee {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(100);
//        bst.getHead().right.right = new Node(40);
//        bst.getHead().right.right.left = new Node(80);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(90);
        bst.getHead().left.right.left = new Node(6);
        bst.getHead().left.right.left = new Node(6);

        isTreeBalanced(bst.getHead());
        System.out.print(isTreeBalanced(bst.getHead()));
    }


    public static boolean isTreeBalanced(Node head) {
        if(head  == null) return true;

        if(helper(head) < 0) return false;
        else return true;
    }

    public static int helper(Node head) {
        if(head == null) return 0;
        int lh = helper(head.left);
        int rh = helper(head.right);

        int  heightAtNode = Math.abs(lh - rh);
        if(heightAtNode > 1) return Integer.MIN_VALUE;
        else return 1+ Math.max(lh,rh);
    }
}
