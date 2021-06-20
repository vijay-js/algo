package BSTLearn.traversals.questions.binarytree.revise.rootToLeaf;

import BSTLearn.Node;

public class CheckIfRootToLeafSumMatches {
    public static void main(String[] args) {

    }

    public static boolean solve(Node head, int sum) {
        if(head == null) return false;

        if(head.left == null && head.right == null) {
            if(sum == head.val ) {
                return true;
            }
        }
        return solve(head.left,sum-head.val) || solve(head.right,sum-head.val);
    }
}
