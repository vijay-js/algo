package BSTLearn.traversals.questions.binarytree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

//Sum of node left and right child is equal to the node value
public class ChildrenSumProperty {


    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(20));
        bst.getHead().right = new Node(12);
        bst.getHead().left = new Node(8);
//        bst.getHead().right.left = new Node(100);
//        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(3);
        bst.getHead().left.right = new Node(5);

        System.out.println(isChildSum(bst.getHead()));


    }

    private static boolean isChildSum(Node head) {
        if(head == null) return true;

        //Imp condition
        if(head.left == null && head.right == null) return true;

        int leftVal = head.left !=null ? head.left.val : 0;
        int rightVal = head.right !=null ? head.right.val: 0;

        boolean hasChildSum;
        if(head.val == leftVal + rightVal)  {
            hasChildSum=  true;
        }
        else {
            hasChildSum =  false;
        }

        return hasChildSum && isChildSum(head.left) && isChildSum(head.right);

    }

}
