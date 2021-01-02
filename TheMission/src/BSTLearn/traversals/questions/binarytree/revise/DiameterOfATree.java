package BSTLearn.traversals.questions.binarytree.revise;

import BSTLearn.Node;

public class DiameterOfATree {

    static class Result {
        int maxVal;
        Result() {
            maxVal = Integer.MIN_VALUE;
        }
    }

    static Result result = new Result();

    public static int calDiameter(Node head) {
        if(head == null) return 0;

        int lh = calDiameter(head.left);
        int rh = calDiameter(head.right);

        int dia = 1 + Math.max(lh,rh);

        if(dia > result.maxVal )  {
            result.maxVal = dia;
        }
        return dia;
    }

}
