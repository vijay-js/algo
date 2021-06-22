package BSTLearn.traversals.questions.binarysearchtree;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class FindInOrderSucsessor {
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

        solve(bst.getHead(),13);
    }

    public static void solve(Node head, int x) {
        Node ans = null;
        if(head == null) return;

        while(head != null) {
            if(head.val == x) {
                if(head.right !=null) {
                    ans = FindMin(head.right);
                }
                if(ans == null) {
                    System.out.println("Not found");
                }
                else {
                    System.out.println(ans.val);
                    break;
                }
            }
            else if(head.val > x) {
                ans = head;
                head = head.left;
            }
            else {
                head = head.right;
            }
        }

    }

    private static Node FindMin(Node node) {
        while(node !=null && node.left!=null) {
            node = node.left;
        }
        return node;
    }
}
