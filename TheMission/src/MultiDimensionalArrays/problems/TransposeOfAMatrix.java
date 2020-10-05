package MultiDimensionalArrays.problems;

import MultiDimensionalArrays.helper;

public class TransposeOfAMatrix {
    public static void main(String[] args) {
        int a[][] = new int[4][4];
        helper.initInSequence(a);
        helper.printArray(a);

//        int b[][] = transposeRowWise(a);
//        helper.printArray(b);
//
//        int c[][] = transposeInPlaceForSquareMatrix(a);
//        helper.printArray(c);

        System.out.println("Transposing Matrix");
        int b[][] = transposeForNonSquareMatrix(a);
        helper.printArray(b);
    }


    public static int[][] transposeForNonSquareMatrix(int a[][]) {
        int m = a.length;
        int n = a[0].length;
        int b[][] = new int[n][m];

        for(int i=0;i<b.length;i++) {
            for(int j=0;j<b[i].length;j++) {
                b[i][j] = a[j][i];
            }
        }
        return b;
    }


    public static int[][] transposeInPlaceForSquareMatrix(int a[][]) {
        for(int i=0;i<a.length;i++) {
            for(int j=i+1;j<a[i].length;j++) {
                swap(a,i,j);
            }
        }
        return a;
    }

    private static void swap(int a[][],int x, int y) {
        int temp = a[x][y];
        a[x][y] = a[y][x];
        a[y][x] = temp;
    }
}
