package BSTLearn.traversals.questions.binarysearchtree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class FindInOrderPredecessor {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(8));
        bst.getHead().right = new Node(10);
        bst.getHead().left = new Node(3);
        bst.getHead().right.right = new Node(14);
        bst.getHead().left.left = new Node(1);
        bst.getHead().left.right = new Node(6);
        bst.getHead().left.right.right = new Node(7);
        bst.getHead().left.right.left = new Node(4);
        bst.getHead().right.right.left = new Node(13);

        findInorderPredecessor(bst.getHead(),14);
    }

    public static void findInorderPredecessor(Node head, int x) {

        Node ans = null;
        if(head == null) return;



        while(head !=null) {
            if(head.val == x) {
                //Case 1 : There's left subTree -> Then return Highest value in left subtree
                if(head.left !=null ) {
                    ans = FindMax(head.left);
                }
                if(ans == null) {
                    System.out.println("No predecessor");
                }
                //Case 2 : Store the last right turn while traversing the element
                else {
                    System.out.println(ans.val);
                }

                break;
            }
            else if(head.val < x) {
                ans = head;
                head = head.right;
            }
            else {
                head = head.left;
            }
        }

    }


    private static Node FindMax(Node temp) {
        while(temp != null && temp.right !=null) {
            temp = temp.right;
        }
        return temp;
    }
}
