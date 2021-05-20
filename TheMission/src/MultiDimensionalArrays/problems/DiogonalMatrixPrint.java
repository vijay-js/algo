package MultiDimensionalArrays.problems;

import MultiDimensionalArrays.helper;

public class DiogonalMatrixPrint {
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        helper.initInSequence(a);
        helper.printArray(a);
        printDiagonalElements(a);
    }


    private static void printDiagonalElements(int[][] a) {
        for(int i=0;i<a.length;i++) {
            int row =i;
            int col = 0;
            while(row>=0) {
                System.out.print(a[row][col] + " ");
                row--;
                col++;
            }
        }

        for(int j=1;j<a[0].length;j++) {
            int row = a.length -1;
            int col = j;

            while(col<=a.length -1) {
                System.out.print(a[row][col] +" ");
                row--;
                col++;
            }
        }
    }
}
