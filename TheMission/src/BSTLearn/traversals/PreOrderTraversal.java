package BSTLearn.traversals;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class PreOrderTraversal {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(15);
        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(9);
        bst.getHead().left.left.left = new Node(4);

        preOrderTraversal(bst.getHead());
    }

    private static void preOrderTraversal(Node head) {
        if(head == null) return;
        System.out.print(head.val + " ");
        preOrderTraversal(head.left);
        preOrderTraversal(head.right);
    }
}
