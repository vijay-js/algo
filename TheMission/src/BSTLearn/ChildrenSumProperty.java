package BSTLearn;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

//Sum of parent = Sum of right + left
public class ChildrenSumProperty {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(10));
        bst.getHead().right = new Node(25);
        bst.getHead().left = new Node(8);
        bst.getHead().right.left = new Node(100);
        bst.getHead().right.right = new Node(40);
        bst.getHead().left.left = new Node(6);
        bst.getHead().left.right = new Node(90);

        boolean answer = followsChildrenSum(bst.getHead());
    }

    private static boolean followsChildrenSum(Node head) {
        if(head == null) return true;
        if(head.left == null && head.right == null) return true;
        int sum = 0;
        if(head.left !=null) sum = sum + head.left.val;
        if(head.right !=null) sum = sum + head.right.val;
        return sum == head.val && followsChildrenSum(head.left) && followsChildrenSum(head.right);
    }
}
