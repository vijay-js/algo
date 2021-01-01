package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;

public class CheckIfTwoTreesAreMirror {

    public boolean checkIfMirror(Node head1, Node head2) {

        if(head1 == null && head2==null) return true;

        if(head1 ==null || head2 == null) return false;

        boolean condition = head1.val == head2.val;

        return condition && checkIfMirror(head1.left,head2.left) && checkIfMirror(head1.right,head2.right);
    }
}
