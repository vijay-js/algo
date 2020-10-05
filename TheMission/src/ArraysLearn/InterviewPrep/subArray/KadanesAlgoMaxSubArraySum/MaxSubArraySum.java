package ArraysLearn.InterviewPrep.subArray.KadanesAlgoMaxSubArraySum;

//Array of both positive and negative numbers
//Till sum <=0 go ahead else mark sum =0


public class MaxSubArraySum {
    public static void main(String[] args) {
        int a[]= {-1,-2,-6,93,-1,-2,-4,-8,-12};

        int sum = findMaxSum(a);
        System.out.println(sum);
    }

    private static int findMaxSum(int a[]) {
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int start =0;
        int end =0;

        int finalStart =0;

        for(int i=0;i<a.length;i++) {
            sum = sum + a[i];
            if(sum <= 0) {
                sum =0;
                start=i+1;
            }
            else {
                max_sum  = Math.max(max_sum,sum);
                if(sum == max_sum) {
                    finalStart = start;
                    end = i;
                }
            }

        }

        System.out.println("Start Index : "+finalStart);
        System.out.println("End Index : "+end);
        return max_sum;

    }
}
