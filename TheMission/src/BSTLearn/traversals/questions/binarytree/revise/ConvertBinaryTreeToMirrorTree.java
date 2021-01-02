package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;


//POst Order TRaversal Is Important here as we

//Itertive version is possible with Level Order Traversal and swap at each node while processing
public class ConvertBinaryTreeToMirrorTree {

    public void mirror(Node head) {
        if(head == null) return;

        mirror(head.left);
        mirror(head.right);

        Node temp = head.left;
        head.left = head.right;
        head.right = temp;

    }

}
