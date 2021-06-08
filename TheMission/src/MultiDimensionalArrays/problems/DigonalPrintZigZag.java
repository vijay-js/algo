package MultiDimensionalArrays.problems;

import java.util.*;

//The key idea is that sum of r+c at each element of the
public class DigonalPrintZigZag {
    public static void main(String[] args) {
        int a[][] = new int[][] {{1,2},{3,4,5,6},{7,8,9},{10,11,12,13}};
        solveZigZag(a);
    }


    private static void solveZigZag(int a[][]) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                map.computeIfAbsent(i+j , x-> new ArrayList<>()).add(a[i][j]);
                max = Math.max(i+j,max);
            }
        }

       for(int i=0;i<=max;i++) {
           List<Integer> list = map.get(i);

           if(i%2 ==0) {
               Collections.reverse(list);
           }

          for(int j: list) System.out.print(j + " ");

       }
    }

}
