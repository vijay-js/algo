package BSTLearn.traversals.questions.binarytree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagOrderTree {

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
        printZigZag(bst.getHead());
        System.out.println();
        zigZag(bst.getHead());
        System.out.println();
        twoStackZigZag(bst.getHead());
    }


    public static void twoStackZigZag(Node head) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if(head !=null) s1.push(head);

        while(!s1.isEmpty() || !s2.isEmpty()) {

            while(!s1.isEmpty()) {
                Node el = s1.pop();
                System.out.print(el.val + " ");
                if(el.left !=null) s2.push(el.left);
                if(el.right !=null) s2.push(el.right);
            }

            while(!s2.isEmpty()) {
                Node el = s2.pop();
                System.out.print(el.val + " ");

                if(el.right !=null) s1.push(el.right);
                if(el.left !=null) s1.push(el.left);
            }

        }

    }

    public static void zigZag(Node head) {
        Queue<Node> queue = new LinkedList<>();

        if(head != null ) {
            queue.add(head);
        }
        boolean flag = true;

        while(!queue.isEmpty()) {

            int  size = queue.size();
            Stack<Node> stack = new Stack<>();
            for(int i=0;i<size;i++) {

                Node el = queue.poll();
                if(flag) {
                    System.out.print(el.val + " ");
                }
                else {
                    stack.push(el);
                }
                if(el.left !=null) {
                    queue.add(el.left);
                }
                if(el.right !=null) {
                    queue.add(el.right);
                }
            }

            if(!flag) {
                while(!stack.isEmpty()) {
                    System.out.print(stack.pop().val + " ");
                }
            }

            flag = !flag;
        }
    }

    public static void printZigZag(Node head) {
        Queue<Node> queue = new LinkedList<>();
        boolean flag = true;
        if(head!=null) {
            queue.add(head);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();


            if(flag) {
                printQueueInOrder(queue);
            }
            else {
                printQueueInReverse(queue);
                reverseQueue(queue);
            }

            for(int i=0;i< size;i++) {

                Node el = queue.poll();

                if(el.left !=null) {
                    queue.add(el.left);
                }
                if(el.right !=null) {
                    queue.add(el.right);
                }
            }

            flag = !flag;

        }

    }

    public static void printQueueInOrder(Queue<Node> queue) {
       for(Node node: queue) {
           System.out.print(node.val + " ");
       }
    }

    public static void printQueueInReverse(Queue<Node> queue) {
        if(queue.isEmpty()) return;

        Node el = queue.poll();

        printQueueInReverse(queue);
        System.out.print(el.val + " ");
        queue.add(el);
    }

    public static void reverseQueue(Queue<Node> queue) {
        if(queue.isEmpty()) return;

        Node el = queue.poll();
        reverseQueue(queue);
        queue.add(el);
    }
}


