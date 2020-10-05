package ArraysLearn.InterviewPrep.prefixSum;

import ArraysLearn.ArrayHelper;

public class prefixSum {
    public static void main(String[] args) {
        int a[] = {1,2,4,6};
        int prefixSum []  = getPrefixSumRec(a);

        ArrayHelper.printArray(prefixSum);
    }

    private static int[] getPrefixSumRec(int[] a) {
        int answer [] = new int[a.length];
        answer[0] = a[0];
        for(int i=1;i<a.length;i++) {
            answer[i] = answer[i-1] + a[i];
        }
        return answer;
    }

    private static int[] getPrefixSum(int[] a) {
        int answer [] = new int[a.length];
        int sum = 0;
        for(int i=0;i<a.length;i++) {
            sum = sum + a[i];
            answer[i] = sum;
        }
        return answer;
    }
}

