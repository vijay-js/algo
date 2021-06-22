package BSTLearn.BFS;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalView {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(2));
        bst.getHead().right = new Node(3);
        bst.getHead().left = new Node(4);
        bst.getHead().left.left = new Node(6);

        bst.getHead().right.left = new Node(5);
        bst.getHead().right.right = new Node(1);

        bst.getHead().right.left.left = new Node(3);
        bst.getHead().right.left.right = new Node(2);
        bst.getHead().right.left.left.left = new Node(1);
        printDiagonals(bst.getHead());

    }

    public static void printDiagonals(Node head) {
        if(head == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()) {


            int size = queue.size();
            int sum = 0;

            //Loop for the elements in the queue for that diagonal
            for(int i=0;i<size;i++) {

                Node curr = queue.poll();

                while(curr != null) {
                    System.out.print(curr.val + " ");
                    sum = sum + curr.val;
                    if(curr.left !=null) {
                        queue.add(curr.left);
                    }
                    curr = curr.right;
                }

            }

            System.out.println();

        }

    }
}
