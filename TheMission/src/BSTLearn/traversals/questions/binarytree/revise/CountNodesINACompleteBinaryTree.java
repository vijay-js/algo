package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;

//Point is complete binary tree
//All nodes are full aand as left as possible
//How to take advantage of this instead of traversing the whole tree
public class CountNodesINACompleteBinaryTree {



    public int countNaive(Node head) {
        if(head == null) return 0;
        return 1+ countNaive(head.left) + countNaive(head.right);
    }

    public int height(Node head) {
        if(head == null) return 0;
        return 1 + Math.max(height(head.left),height(head.right));
    }

    public int heightLeftSubtree(Node head) {
        if(head == null) return 0;
        int count = 0;
        while(head !=null) {
            head = head.left;
            count++;
        }
        return count;
    }

    public int heightRightSubtree(Node head) {
        if(head == null) return 0;
        int count = 0;
        while(head !=null) {
            head = head.right;
            count++;
        }
        return count;
    }

    public int countEfficient(Node head) {
        int heightLeftSubTree = heightLeftSubtree(head);
        int heightRightSubTree = heightRightSubtree(head);

        if(heightLeftSubTree == heightRightSubTree) {
            return (int)Math.pow(2,heightLeftSubTree) -1;
        }

        else {
            return 1 + countEfficient(head.left) + countEfficient(head.right);
        }

    }
}
