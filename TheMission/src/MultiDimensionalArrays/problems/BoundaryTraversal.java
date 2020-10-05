package MultiDimensionalArrays.problems;

import MultiDimensionalArrays.helper;

public class BoundaryTraversal {
    public static void main(String[] args) {
        int a[][] = new int[3][4];

        helper.initInSequence(a);
        helper.printArray(a);

        printBoundaries(a);
    }

    private static void printBoundaries(int a[][]) {
        for(int i=0;i<a[0].length;i++) {
            System.out.print(a[0][i] + " ");
        }

        for(int i=1;i<a.length;i++) {
            System.out.print(a[i][a[0].length -1] + " ");
        }

        for(int j=a[0].length-2;j>=0;j--) {
            System.out.print(a[a.length-1][j] + " ");
        }

        for (int i=a.length-2;i>0;i--) {
            System.out.print(a[i][0] +" ");
        }

        System.out.println();


    }
}
