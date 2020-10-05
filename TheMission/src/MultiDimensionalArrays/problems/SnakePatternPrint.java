package MultiDimensionalArrays.problems;

import MultiDimensionalArrays.helper;

public class SnakePatternPrint {
    public static void main(String[] args) {
        int a[][] = new int [3][3];
        helper.initInSequence(a);
        helper.printArray(a);
//        printInSnakePattern(a);
        printSnakePattern(a);
    }

    public static void printInSnakePattern(int a[][]) {
        boolean flag = true;

        for(int i=0;i<a.length;i++) {
            int[] row = a[i];
            if(flag) {
                for(int j=0;j<row.length;j++) {
                    System.out.print(a[i][j] + " ");
                }
            }
            else {
                for(int j=row.length-1;j>=0;j--) {
                    System.out.print(a[i][j] + " ");
                }
            }
            flag = !flag;
        }
    }

    public static void printSnakePattern(int a[][]) {
        boolean right = true;
        for(int i=0;i<a.length;i++) {
            if(right) {
                for(int j=0;j<a[i].length;j++) {
                    System.out.print(a[i][j] + " ");
                }
            }
            else {
                for (int j = a[i].length-1; j >= 0; j--) {
                    System.out.print(a[i][j] + " ");
                }
            }
            right = !right;
        }
        System.out.println();
    }
}
