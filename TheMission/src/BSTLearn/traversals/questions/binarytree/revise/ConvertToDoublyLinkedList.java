package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;



//This is from GeeksForGeeks Theory Class

public class ConvertToDoublyLinkedList {
    static Node prev = null;
    public static void main(String args[]) {

    }

    public Node convert(Node root) {
        if(root == null) return root;
        Node head=convert(root.left);
        if(prev == null) {
            head = root;
        }
        else {
            root.left = prev;
            prev.right = root;

        }
        prev = root;
        convert(root.right);
        return head;

    }

}
