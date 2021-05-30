package ArraysLearn.InterviewPrep.subArray.KadanesAlgoMaxSubArraySum;

//Array of both positive and negative numbers
//Till sum <=0 go ahead else mark sum =0


public class MaxSubArraySum {
    public static void main(String[] args) {
        int a[]= {1,2,-6,-3,-1,-2,-4,-8,-1};

        int sum1 = findMaxSubArraySum(a);
        System.out.println( sum1);
    }

    private static int findMaxSubArraySum(int a[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        //marker for next possible start index.
        int s = 0;
        int startIndex = 0;
        int endIndex = -1;

       //Only when the sum is larger than before update both start and end
        for(int i=0;i<a.length;i++) {
            sum = sum + a[i];
            if(sum > 0) {
                if(sum > maxSum) {
                    maxSum = sum;
                    //Start would be already marked in s - end can be this
                    startIndex = s;
                    endIndex = i;
                }
            }
            else {
                sum = 0;
                //Mark the next possible start
                s = i +1;
            }
        }

        System.out.println(startIndex + "--" + endIndex);
        return maxSum;
    }
}
