package MultiDimensionalArrays.problems;

import MultiDimensionalArrays.helper;

public class FlipAnImage {

    public static void main(String[] args) {
        int a[][] = new int[][] {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };

        helper.printArray(a);
        flip(a);
        System.out.println("After flip");
        helper.printArray(a);

    }
    public static void flip(int a[][]) {
        for(int i=0;i<a.length;i++) {

            for(int j=0;j<(a[i].length +1)/2;j++) {

                int temp = a[i][j];
                a[i][j] = a[i][a[i].length -1 -j] == 0 ? 1 : 0;
                a[i][a[i].length -1 -j] = temp == 0 ? 1: 0;


            }
        }
    }
}


