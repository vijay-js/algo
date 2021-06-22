package BSTLearn.traversals.questions.binarysearchtree;

import BSTLearn.Node;

public class DeleteInBST {
    public static void main(String[] args) {

    }

    //Returns the head of the tree
    public static Node delete(Node head, int x) {
        if(head == null) return null;

        if(head.val >x) {
            head.left = delete(head.left,x);
        }
        else if(head.val < x) {
            head.right = delete(head.right,x);
        }

        //Found the item to be deleted
        else {
            //Case 1: No children //
            if(head.left == null && head.right == null) {
                return null;
            }

            //Case 2 : Only one subtree exists
            if(head.left == null) {
                return head.right;
            }
            if(head.right == null) {
                return head.left;
            }

            //Case 3 : Both subtrees exist
            //FindMin of Right Subtree or FindMax of LeftSubtree
            Node node = FindMin(head.right);
            head.val = node.val;
            head.right = delete(head.right,node.val);

        }
        return null;
    }

    private static Node FindMin(Node temp) {
        if(temp!=null && temp.left!=null) {
            temp = temp.left;
        }
        return temp;
    }
}
