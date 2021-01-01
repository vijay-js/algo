package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToLeafPaths {

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

        print(bst.getHead(),paths,"");

        System.out.print(paths);
    }

    public static void print(Node head, List<String> paths,String pattern) {
        if(head == null) return;

        print(head.left,paths,pattern+ "," + head.val);
        if(head.left == null && head.right == null) {
            pattern= pattern + "," +head.val;
            paths.add(pattern);
        }


        print(head.right,paths,pattern+","+head.val);

    }
}
