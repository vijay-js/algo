package BSTLearn.BFS;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfATree {
    static int MAX_LEVEL = Integer.MIN_VALUE;

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
        leftView(bst.getHead());
        System.out.println();
        leftViewRec(bst.getHead(),0);
    }

    private static void leftViewRec(Node head,int level) {
        if(head == null) return;
        if(level> MAX_LEVEL) {
            System.out.print(head.val +" ");
            MAX_LEVEL = level;
        }
        leftViewRec(head.left,level +1);
        leftViewRec(head.right, level+1);
    }

    private static void leftView(Node head) {
        if(head == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(head);

        while(!q.isEmpty()) {

            int size = q.size();
            Node current = q.poll();

            System.out.print(current.val + " ");

            if(current.left != null) q.add(current.left);
            if(current.right != null) q.add(current.right);

            int i =0;
            while(i< size -1) {
                Node temp = q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                i++;
            }
        }
    }
}
