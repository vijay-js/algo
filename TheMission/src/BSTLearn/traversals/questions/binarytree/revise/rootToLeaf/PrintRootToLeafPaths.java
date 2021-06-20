package BSTLearn.traversals.questions.binarytree.revise.rootToLeaf;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintRootToLeafPaths {

   static  Stack<Integer> stack = new Stack<>();

    public static void main(String args[]) {
        List<String> paths = new ArrayList<>();
        List<Integer> paths1 = new ArrayList<>();

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
        printUsingStack(bst.getHead());
        System.out.print(paths);
        System.out.println();
        printYay(bst.getHead(),paths1);
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


    //Another way is to use stack to print the path

    //Interesting

    public static void printUsingStack(Node head)  {
        if(head == null) {
            return;
        }
        stack.push(head.val);
        if(head.left == null && head.right == null) {
            printStack(stack);
        }
        printUsingStack(head.left);
        printUsingStack(head.right);
        stack.pop();
    }

    public static void printStack(Stack<Integer> stack) {
        for(Integer i: stack) {
            System.out.print(i +  ",");
        }
        System.out.println();
    }

    public static void printYay(Node head,List<Integer> paths) {
        if(head == null) return;
        paths.add(head.val);
        if(head.left == null && head.right == null) {
            for(int i: paths) {
                System.out.print(i + ",");
            }
            System.out.println();
            return;
        }

        printYay(head.left,paths);

        printYay(head.right,paths);

        paths.remove(paths.size()-1);


    }
}
