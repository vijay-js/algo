package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;

public class CheckIfSubTree {
    public static void main(String[] args) {

    }

    private static boolean isSame(Node head, Node subHead) {
        if(head == null && subHead == null) return true;
        if(head == null || subHead == null) return false;

        return head.val == subHead.val && isSame(head.left,subHead.left) && isSame(head.right,subHead.right);
    }

    private static boolean isSubTree(Node head, Node subHead) {
        if(subHead == null) return true;
        if(head == null) return false;

        return isSame(head,subHead) || isSubTree(head.left,subHead) || isSubTree(head.right,subHead);


    }
}

