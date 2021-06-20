package BSTLearn.traversals.questions.binarytree.revise.rootToLeaf;

import BSTLearn.Node;

public class SumofAllNumbersFormedFromRootToLeafPaths {
    int sumOfAll = 0;
    public static void main(String[] args) {

    }

    //If there are 2 digits -> Use String and concantenaye
    public void solve(Node head, int num) {
        if(head == null) return;

        if(head.left == null && head.right == null) {
            sumOfAll = sumOfAll + (num*10 + head.val);
        }

        solve(head.left, num*10 + head.val);
        solve(head.right, num*10 + head.val);
    }
}
