package BSTLearn.traversals.questions.binarytree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;

//Print all paths from root with given sum
public class PrintPathsWithGivenSum {

    public static void main(String args[]) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(5));
        Node head = bst.getHead();

        head.left = new Node(2);
        head.right = new Node(3);

        head.left.left = new Node(10);
        head.left.right = new Node(11);

        head.right.left = new Node(3);
        head.right.right = new Node(5);

        head.left.left.left = new Node(1);

        head.right.right.right = new Node(4);
        head.right.right.right.right = new Node(1);

        ArrayList<Integer> arr = new ArrayList<>();

        printPathsWithSum(head,18,arr);
    }

    public static void printPathsWithSum(Node head, int sum, ArrayList<Integer> arrayList) {

        if(head == null) return;



        arrayList.add(head.val);
        if(head.val == sum) {
            printArrayList(arrayList);
        }

//        if(sum <0) return;

        printPathsWithSum(head.left,sum-head.val,arrayList);


        printPathsWithSum(head.right,sum-head.val,arrayList);

        arrayList.remove(arrayList.size()-1);


    }

    private static void printArrayList(ArrayList<Integer> arrayList) {
        for(Integer i : arrayList) {
            System.out.print(i + " , ");
        }
        System.out.println();
    }
}
