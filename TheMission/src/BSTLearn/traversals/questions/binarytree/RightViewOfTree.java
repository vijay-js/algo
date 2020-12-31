package BSTLearn.traversals.questions.binarytree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.*;

public class RightViewOfTree {
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
        rightView(bst.getHead());
        Set<Integer> set = new HashSet<>();
        System.out.println();
        rightViewDFS(bst.getHead(),0,set);


        DepthNode node = new DepthNode(10);

        node.right = new DepthNode(25);
        node.left = new DepthNode(8);
        node.right.left = new DepthNode(15);
        node.right.right = new DepthNode(40);
        node.left.left = new DepthNode(6);
        node.left.right = new DepthNode(9);
        node.left.left.left = new DepthNode(4);


        System.out.println();
        addDepth(node,0);
        printDepths( node);
    }

    static class DepthNode{
        int val;
        DepthNode left;
        DepthNode right;
        int depth;

        DepthNode(int val) {
            this.val = val;
        }
    }

    public static void printDepths(DepthNode head) {
        Queue<DepthNode> queue = new LinkedList<>();

        if(head !=null) queue.add(head);

        while(!queue.isEmpty()) {
            DepthNode node = queue.poll();
            System.out.println(node.val + " " + node.depth);
            if(node.left !=null) queue.add(node.left);
            if(node.right !=null) queue.add(node.right);
        }
    }


    public static void addDepth(DepthNode head, int depth) {
        if(head == null) return;
        head.depth = depth;
        addDepth(head.left,depth+1);
        addDepth(head.right,depth+1);
    }


    public static void rightView(Node head) {
        Queue<Node> queue = new LinkedList<>();
        if(head!=null) queue.add(head);

        while(!queue.isEmpty()){

            int size= queue.size();

            for(int i=0;i<size;i++) {
                Node el = queue.poll();
                if(i == size-1) {
                    System.out.print(el.val + " ");
                }
                if(el.left !=null) queue.add(el.left);
                if(el.right !=null) queue.add(el.right);
            }

        }
    }


    public static void rightViewDFS(Node head,int depth,Set<Integer> set) {
        if(head == null) return;
        if(!set.contains(depth)) {
            System.out.print(head.val + " ");
            set.add(depth);
        }
        rightViewDFS(head.right,depth+1,set);
        rightViewDFS(head.left,depth+1,set);
    }
}
