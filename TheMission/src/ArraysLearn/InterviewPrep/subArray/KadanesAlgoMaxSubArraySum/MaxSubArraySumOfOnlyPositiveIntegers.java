package ArraysLearn.InterviewPrep.subArray.KadanesAlgoMaxSubArraySum;
/*
*
* Largest sum contiguous subarray having only non-negative elements
*
* */
public class MaxSubArraySumOfOnlyPositiveIntegers {
    public static void main(String[] args) {
        int a[] = new int[] {1, 4, -3, 9, 5, -6};
        System.out.println(solve(a));
    }

    private static int solve(int a[]) {
        int sum =0;
        int maxSum = Integer.MIN_VALUE;
        int start =0;
        int s =0;
        int end = -1;

        for(int i=0;i<a.length;i++) {
            if(a[i] < 0) {
                sum =0;
                s = i+1;
                continue;
            }
            sum = sum + a[i];

            if(sum > maxSum) {
                maxSum = sum;
                start = s;
                end = i;
            }


        }
        System.out.println("Start index " +start);
        System.out.println("End index " +end);
        return maxSum;
    }
}
