package ArraysLearn.InterviewPrep.prefixSum;


//Given N ranges of form [L,R] - The task is to find max occuring integer in all the ranges. If more than one exist - return the min


import ArraysLearn.ArrayHelper;

import java.util.ArrayList;
import java.util.List;

public class MaxOcuuringIntegerInNRanges {


    public static void main(String[] args) {
        List<Range> rangeList = new ArrayList<>();
        Range r1 = new Range(2,20);
        Range r2 = new Range(3,7);
        Range r3 = new Range(1,5);
        Range r4 = new Range(0,4);

        rangeList.add(r1);
        rangeList.add(r2);
        rangeList.add(r3);
        rangeList.add(r4);

        int n = findMostCommon(rangeList);


    }


    private static int findMostCommon(List<Range> ranges) {

        int MAX_RANGE = 31 ; //ASSUMPTION -- Can be anything less than some max int value
        int a[] = new int[MAX_RANGE];

        int prefix_sum[] = new int[MAX_RANGE];

        for(Range r: ranges) {
            a[r.left] = a[r.left] + 1;
            a[r.right +1 ] = a[r.right +1] -1;
        }

        prefix_sum[0] = a[0];
        for(int i=1;i<a.length;i++) {
            prefix_sum[i] = prefix_sum[i-1] + a[i];
        }
        ArrayHelper.printArray(a);
        ArrayHelper.printArray(prefix_sum);
        return 1;
    }

    public static class Range {
        private int left;
        private int right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}

