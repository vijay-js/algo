package ArraysLearn.InterviewPrep.slidingWindow;

public class MaxContinousSubArraySum {
    public static void main(String[] args) {
        int a[] = {2, 1, 5, 1, 3, 2};
        int k =3;
        int sum = findMaxSumOfKConsecutive(a,k);
        int sum1 = naiveFindSumOfKConsecutive(a,k);
        System.out.println(sum);
        System.out.println(sum1);
    }

    private static int findMaxSumOfKConsecutive(int a[],int k) {

        if(a.length < k) {
            throw new AssertionError("The value of k should be greater than array length");
        }

        int window_sum = 0;

        //Calculate the first window sum
        for(int i=0;i<k;i++) {
            window_sum = window_sum + a[i];
        }
        //Initiliaze the first max_sum with window sum
        int max_sum = window_sum;

        for(int j=k;j<a.length;j++) {
            window_sum = window_sum + a[j] - a[j-k];
            max_sum = Math.max(max_sum,window_sum);
        }
        return max_sum;
    }


    private static int naiveFindSumOfKConsecutive(int a[], int k) {
        if(a.length < k) {
            throw new AssertionError("The value of k should be greater than array length");
        }

        int max_sum = Integer.MIN_VALUE;

        for(int i=0;i+k-1<a.length;i++) {
            int sum = 0;
            for(int j=0;j<k;j++) {
                sum = sum + a[i+j];
            }
            if(sum > max_sum) {
                max_sum = sum;
            }
        }
        return max_sum;
    }
}
