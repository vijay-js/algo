package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;

public class CheckHeightBalancedTree {

    //Returns -1 if unbalanced or height otherwise
    public static int checkBalancedEfficient(Node head) {
        if(head == null) return 0;

        int lh = checkBalancedEfficient(head.left);

        if(lh == -1) return -1;

        int rh = checkBalancedEfficient(head.right);

        if(rh == -1) return -1;

        if(Math.abs(lh -rh) > 1) return -1;

        else return Math.max(lh,rh)  + 1;
    }


    public static boolean checkBalanced(Node head) {
        if(head == null) return true;

        int lh= findHeight(head.left);
        int rh = findHeight(head.right);


        if(lh -rh > 1) {
            return false;
        }

        return Math.abs(lh-rh) <=1 && checkBalanced(head.left) && checkBalanced(head.right);
    }

    private static int findHeight(Node head) {
        if(head == null) return -1;

       return 1 + Math.max(findHeight(head.left), findHeight(head.right));

    }
}
