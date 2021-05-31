package ArraysLearn.InterviewPrep.subArray.KadanesAlgoMaxSubArraySum;
/*
* Given n numbers (both +ve and -ve), arranged in a circle, find the maximum sum of consecutive numbers.
 *
 *
Input: a[] = {8, -8, 9, -9, 10, -11, 12}
Output: 22 (12 + 8 - 8 + 9 - 9 + 10)

Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1}
Output:  23 (7 + 6 + 5 - 4 -1 + 10)

Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
 *
 *
 *
 * The Key idea is to find the minimum value of the sum using reverse kadane
 * And then subtract this frm total sum
* */
public class MaxCircularSubArraySum {
    public static void main(String[] args) {
        int a[] = new int[] {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println(solve(a));
    }

    private static int kadane(int a[]) {
        int sum =0;
        int maxSum = Integer.MIN_VALUE;



        for(int i=0;i<a.length;i++) {

            sum = sum+ a[i];
            if(sum < 0) {
                sum =0;
                continue;
            }
            if(sum > maxSum) {
                maxSum = sum;
            }

        }
        return maxSum;
    }

    private static  int solve(int [] a) {
        int kadane_sum = kadane(a);
        int totalSum = 0;
        for(int i=0;i<a.length;i++) {
            totalSum = totalSum + a[i];
            a[i] = -a[i];
        }
        int reverseKadane = kadane(a);

        return Math.max(kadane_sum, totalSum - (-reverseKadane));

    }
}
