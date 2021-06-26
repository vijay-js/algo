package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;


//Post Order Traversal Is Important here as we

//Itertive version is possible with Level Order Traversal and swap at each node while processing
public class ConvertBinaryTreeToMirrorTree {

    //This is preorder
    public void mirror(Node head) {
        if(head == null) return;


        Node temp = head.left;
        head.left = head.right;
        head.right = temp;

        mirror(head.left);
        mirror(head.right);


    }

    //Can also be done in postOrder
    public Node mirror2(Node head) {
        if(head == null) return null;

        Node left = mirror2(head.left);
        Node right = mirror2(head.right);
        head.left = right;
        head.right = left;
        return head;
    }

}
