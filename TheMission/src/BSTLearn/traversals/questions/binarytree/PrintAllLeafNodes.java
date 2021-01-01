package BSTLearn.traversals.questions.binarytree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class PrintAllLeafNodes {

    public static void main(String args[]) {

        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
//        bst.getHead().right.left = new Node(100);
//        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(90);

        printLeafNodes(bst.getHead());

        System.out.println();
        System.out.println(countLeafNodes(bst.getHead()));

    }

    public static int printLeafNodes(Node head) {
        if(head == null) return -1;

       int lh= printLeafNodes(head.left);
       int rh = printLeafNodes(head.right);

       if(lh + rh == -2) {
           System.out.print(head.val + " ");
           return 0;
       }
       return lh+rh;
    }

    public static int countLeafNodes(Node head) {
        if(head == null) return 0;
        if(head.left == null && head.right == null) return 1;

       return countLeafNodes(head.left) + countLeafNodes(head.right);

    }
}
