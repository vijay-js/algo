package BSTLearn.traversals.questions.binarytree;

import BSTLearn.Node;

public class CheckIfTwoTreesAreIdentical {
    public boolean checkIfIdentical(Node head1, Node head2) {
        if(head1 == null && head2 == null) return true;

        if(head1 == null || head2 == null) return false;

        if(head1.val != head2.val) return false;

        return checkIfIdentical(head1.left,head2.left) && checkIfIdentical(head1.right,head2.right);
    }
}
