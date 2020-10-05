package BSTLearn.traversals;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.Stack;

public class IterativeInOrderTraversal {
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

        IterativeInOrderTraversal(bst.getHead());
    }

    public static void IterativeInOrderTraversal(Node head) {
        if(head == null) return;
        Stack<Node> s = new Stack<>();
        Node current = head;
        while(current !=null || !s.isEmpty()) {

            while(current!=null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }

    }
}
