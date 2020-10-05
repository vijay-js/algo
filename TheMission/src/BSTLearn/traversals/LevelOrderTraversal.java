package BSTLearn.traversals;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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
        levelOrderTraversal(bst.getHead());
    }

    private static void levelOrderTraversal(Node head) {
        Queue<Node> q = new LinkedList<>();
        if(head != null) {
            q.offer(head);
        }
        while(!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.val + " ");

            if(current.left !=null) {
                q.offer(current.left);
            }
            if(current.right!=null) {
                q.offer(current.right);
            }
        }
    }
}
