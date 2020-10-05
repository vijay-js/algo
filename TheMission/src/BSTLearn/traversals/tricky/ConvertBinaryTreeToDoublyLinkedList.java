package BSTLearn.traversals.tricky;

import BSTLearn.BSTImpl;
import BSTLearn.Node;


//InOrder Doubly Linked List

public class ConvertBinaryTreeToDoublyLinkedList {
    static Node prev = null;
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

        convertToDLLInPlace(bst.getHead());
    }



    public static Node convertToDLLInPlace(Node root) {
        if(root == null) return root;

        Node head = convertToDLLInPlace(root.left);

        if(prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDLLInPlace(root.right);
        return head;
    }
}
