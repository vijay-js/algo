package ArraysLearn.InterviewPrep.subArray;
/*
* Given an array a[] of N integers, the task is to find the length of the longest Alternating Even Odd subarray present in the array.

 * */
public class AlternatingEvenOddSubArray {
    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5,5,6,7};
        System.out.println(solve(a));
    }

    private static int solve(int a[]) {
        if(a.length ==0) return 0;
        int count =0;
        int maxCount = Integer.MIN_VALUE;
        boolean prevIsEven = (a[0]%2 ==0);

        for(int i=1;i<a.length;i++) {
            boolean currentIsEven = (a[i] %2 == 0);
            if(prevIsEven == currentIsEven) {
                count = 0;
                prevIsEven = currentIsEven;
                continue;
            }
            else {
                count++;
                prevIsEven = currentIsEven;
                maxCount = Math.max(count,maxCount);
            }
        }
        if(maxCount != Integer.MIN_VALUE) {
            return maxCount+1;
        }
        else {
            return 0;
        }
    }

}
