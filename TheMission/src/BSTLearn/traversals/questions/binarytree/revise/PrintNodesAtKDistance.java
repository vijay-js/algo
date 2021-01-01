package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesAtKDistance {

    public static void main(String args[]) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(15);
        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(9);
        bst.getHead().left.left.left = new Node(4);

        int k = 0;

        printAtK(bst.getHead(),k);
        System.out.println();
        printAtLevel(bst.getHead(),k);
    }

    public static void printAtK(Node head,int k) {
        printAtKUtil(head,0,k);
    }

    public static void printAtKUtil(Node head,int depth,int  k) {
        if(head == null) return;

        if(depth ==k) {
            System.out.print(head.val + " ");
        }

        printAtKUtil(head.left,depth+1,k);
        printAtKUtil(head.right,depth+1,k);


    }

    //Can also be done using BFS

    public static void printAtLevel(Node head, int k) {
        int level = 0;

        Queue<Node> queue = new LinkedList<>();
        if(head !=null) queue.add(head);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node el = queue.poll();
                if(level == k) {
                    System.out.print(el.val + " ");
                }
                if(el.left !=null) queue.add(el.left);
                if(el.right !=null) queue.add(el.right);
            }
            level++;
        }

    }
}
