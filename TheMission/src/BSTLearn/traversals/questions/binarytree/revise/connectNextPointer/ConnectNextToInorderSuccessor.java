package BSTLearn.traversals.questions.binarytree.revise.connectNextPointer;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class ConnectNextToInorderSuccessor {
    static Node prev = null;
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.setHead(new Node(1));
        bst.getHead().right = new Node(3);
        bst.getHead().left = new Node(2);
        bst.getHead().right.left = new Node(6);
        bst.getHead().left.left = new Node(4);
        bst.getHead().left.right = new Node(5);
        bst.getHead().left.left.left = new Node(7);
        bst.getHead().left.right.left = new Node(8);

        solve(bst.getHead());

        Node curr = bst.getHead();

        while(curr !=null) {
            System.out.print(curr.val +" ");
            curr = curr.nextRight;
        }

        System.out.println();
    }

    public static void solve(Node head) {
        if(head == null) return;

        solve(head.left);

        if(prev !=null) {
            prev.nextRight = head;
        }
        prev = head;
        solve(head.right);
    }
}
