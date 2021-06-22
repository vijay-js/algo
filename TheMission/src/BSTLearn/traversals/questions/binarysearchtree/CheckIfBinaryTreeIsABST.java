package BSTLearn.traversals.questions.binarysearchtree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class CheckIfBinaryTreeIsABST {
    public static void main(String[] args) {

        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(5));
        bst.getHead().right = new Node(8);
        bst.getHead().left = new Node(1);
        bst.getHead().right.left = new Node(9);
        bst.getHead().right.right = new Node(12);
//        bst.getHead().left.left = new Node(1);
//        bst.getHead().left.right = new Node(6);
//        bst.getHead().left.left.left = new Node(1);
//        bst.getHead().left.right.right = new Node(11);

        System.out.println(isBST(bst.getHead()));
    }

    public static boolean isBST(Node head) {

        return solve(head,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean solve(Node head, int minValue, int maxValue) {
        //Check for current node

        if(head == null) return true;

//        int left_value = head.left !=null ? head.left.val : Integer.MIN_VALUE;
//        int right_value = head.right !=null ? head.right.val : Integer.MAX_VALUE;

//        boolean isNodeWithinChildBounds = head.val > left_value && head.val < right_value;
        boolean isNodeWithinTreeBounds = head.val > minValue && head.val < maxValue;

        return   isNodeWithinTreeBounds && solve(head.left,minValue,head.val) && solve(head.right,head.val,maxValue);

    }
}
