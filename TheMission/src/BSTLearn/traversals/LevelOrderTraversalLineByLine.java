package BSTLearn.traversals;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {
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
        levelOrderTraversalLineByLine(bst.getHead());
    }

    public static void levelOrderTraversalLineByLine(Node head) {
        if (head == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(head);

        while(!q.isEmpty()) {
            int size = q.size();
            int i =0;
            while(i<size) {
                Node current = q.poll();

                System.out.print(current.val + " ");

                if(current.left !=null) q.add(current.left);
                if(current.right != null)  q.add(current.right);

                i++;
            }
            System.out.println();
        }


    }
}
