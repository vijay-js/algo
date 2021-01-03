package BSTLearn.traversals.questions.binarysearchtree;

import BSTLearn.Node;

public class FindFloorInBST {

    public static Node findFloor(Node head, int x) {
        if(head == null) return null;

        Node result = null;
        Node current = head;
        while(current !=null) {
            if(current.val == x) {
                return current;
            }
            if(current.val > x) {
                current = current.left;
            }
            else {
                result = current;
                current = current.right;
            }
        }
        return result;
    }
}
