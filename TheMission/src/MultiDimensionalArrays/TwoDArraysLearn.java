package MultiDimensionalArrays;

import java.util.Arrays;

public class TwoDArraysLearn {
    public static void main(String[] args) {
        int a[][] = new int[4][4];
        helper.initInSequence(a);
        helper.printArray(a);
//        helper.printArrayColumnWise(a);
//        helper.printRowWise(a,2);
//        helper.printColumnWise(a,0);

        reverseRows(a);
        helper.printArray(a);

        reverseColumns(a);
        helper.printArray(a);

        revColumns2(a);
        helper.printArray(a);

        /*
        *
        * This is to initialize each row with different columns.
        *
        * */
//        int b[][] = new int[3][];
//        b[0] = new int[2];
//        b[1] = new int[4];
//        b[2] = new int [3];
//
//        int count = 1;
//        for(int i=0;i<b.length;i++) {
//            for(int j=0;j<b[i].length;j++) {
//                b[i][j] = count++;
//                System.out.print(b[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        //Get MaxColumn Length
//        int maxColLength = Integer.MIN_VALUE;
//        for(int i=0;i<b.length;i++) {
//            maxColLength = Math.max(maxColLength,b[i].length);
//        }
//
//        for(int j=0;j<maxColLength;j++) {
//            for(int i=0;i<b.length;i++) {
//                try {
//                    System.out.print(b[i][j] + " ");
//                }
//                catch (Exception e) {
//                    System.out.print("E");
//                }
//            }
//            System.out.println();
//        }


    }

    private static void reverseRows(int a[][]) {
        System.out.println("Reversing Rows");
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<(a[i].length)/2;j++) {
               int temp = a[i][j];
               a[i][j] = a[i][a[i].length - j-1];
               a[i][a[i].length - j-1] = temp;
            }
        }
    }

    private static void reverseColumns(int a[][]) {
        System.out.println("Reversing Columns");
        for(int j=0;j<a[0].length;j++) {
            for(int i=0;i<a.length/2;i++) {
                int temp = a[i][j];
                a[i][j] = a[a.length -1 -i][j];
                a[a.length -1 -i][j] = temp;
            }
        }
    }

    private static void revColumns2(int a[][]) {
        System.out.println("Reversing Columns 2");
        for(int i=0;i<a.length/2;i++) {
            int temp[] = Arrays.copyOf(a[i],a[i].length);
            int temp2[] = Arrays.copyOf(a[a.length -i -1],a[a.length-i-1].length);
            a[a.length -i -1] = temp;
            a[i] = temp2;
        }
    }


}
