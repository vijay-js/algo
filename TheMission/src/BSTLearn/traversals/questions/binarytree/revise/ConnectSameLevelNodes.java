package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectSameLevelNodes {

    public static void main(String args[]) {
        List<String> paths = new ArrayList<>();

        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(30);
        bst.getHead().left = new Node(20);
        bst.getHead().right.left = new Node(60);
        bst.getHead().right.right = new Node(70);
        bst.getHead().right.right.right = new Node(120);
        bst.getHead().left.left = new Node(40);
        bst.getHead().left.right = new Node(50);

        bst.getHead().left.right.left = new Node(80);
        bst.getHead().left.right.right = new Node(90);
        bst.getHead().left.right.right.left =new Node(100);
        bst.getHead().left.right.right.right =new Node(110);

        connect(bst.getHead());
        System.out.println();
    }

    public static void connect(Node p) {
        Queue<Node> queue = new LinkedList<>();
        if(p!=null) {
            queue.add(p);
        }

        while(!queue.isEmpty()) {
            Queue<Node> temp = new LinkedList<>();
            int  size = queue.size();
            for(int i=0;i<size;i++) {
                Node el = queue.poll();
                temp.add(el);
                if(el.left!=null) queue.add(el.left);
                if(el.right!=null) queue.add(el.right);
            }

            Node current = temp.poll();
            Node next = null;
            while(current != null) {
                next = !temp.isEmpty() ? temp.poll() : null;
                current.nextRight = next;
                current = next;
            }
        }
    }
}

