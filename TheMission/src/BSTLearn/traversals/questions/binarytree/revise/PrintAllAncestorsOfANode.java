package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.BSTImpl;
import BSTLearn.Node;

public class PrintAllAncestorsOfANode {

    public int printAncestors(Node head,Node node) {

        if(head == null) return -1;

        if(head.val == node.val) {
            return 1;
        }

        if(printAncestors(head.left ,node) == 1 ||  printAncestors(head.right,node) == 1){
            System.out.print(head.val);
            return 1;
        }
       return -1;
    }


}
