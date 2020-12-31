package BSTLearn.traversals.questions.binarytree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

//This is for a Binary Tree
public class MaxOfBinaryTree {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(100);
        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(90);

        int t = findMax(bst.getHead());
        System.out.println(t);
        Result r = new Result(Integer.MIN_VALUE);
        findMaxHelper(bst.getHead(),r);
        System.out.println(r.val);
    }

    private static int findMax(Node head) {
        if(head == null) return -1;
        return maxOf3(head.val,findMax(head.left),findMax(head.right));
    }

    private static int maxOf3(int a, int b, int c) {
        if(a >=b && a>=c) return a;
        else if(b>=a && b>=c) return b;
        return c;
    }

    static class Result {
        int val;

        Result(int i) {
            val = i;
        }
    }

    private static void findMaxHelper(Node head, Result result) {
        if(head == null) return;
        if(head.val > result.val) result.val = head.val;
        findMaxHelper(head.left,result);
        findMaxHelper(head.right,result);
    }

}
