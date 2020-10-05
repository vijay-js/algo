package MultiDimensionalArrays.problems;

import MultiDimensionalArrays.helper;

//Use TRansapose of a matrix
public class RotateMatrix {
    public static void main(String[] args) {
        int a[][] = new int[3][3];

        helper.initInSequence(a);
        helper.printArray(a);


        rotateMatrixCounterClockWise(a);
        helper.printArray(a);
    }


    public static void rotateMatrixCounterClockWise(int a[][]) {
        System.out.println("Rotating Matrix Counter Clock wise");
        reverseEachRow(a);
        transpose(a);
    }


    private static void reverseEachRow(int a[][]) {
        for(int i=0;i<a.length;i++) {
            int row[] = a[i];
            int end = row.length-1;
            for(int j=0;j<row.length && j<end;j++, end--) {
                int temp = row[j];
                row[j] = row[end];
                row[end] = temp;
            }
        }
    }

    private static void transpose(int a[][]) {
        for(int i=0;i<a.length;i++) {
            for(int j=i+1;j<a[i].length;j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }
}
