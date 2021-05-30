package ArraysLearn.InterviewPrep.prefixSum;

public class SplitArrayIntoThreePartsOfEqualSum {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 3, 4, 0, 4};

        canBeSplit(arr);

    }

    private static void canBeSplit(int a[]) {
        int len = a.length;
        int preSum[] = new int[len];
        int sum = a[0];
        preSum[0] = a[0];

        for (int i=1;i<len;i++) {
            preSum[i] = preSum[i-1]+a[i];
            sum += a[i];
        }
        //See if sum is divisible by 3

        if(sum%3 != 0) {
            System.out.println("Cant split the array into 3 parts");
            return;
        }

        int sumOfEachPart = sum/3;

        int break1 = -1, break2 = -1;

        for(int i=0;i<len;i++) {
            if(preSum[i] == sumOfEachPart && break1 == -1) {
                break1 = i;
            }
            if(preSum[i] == 2 *sumOfEachPart && break1 != -1){
                break2 = i;
            }
        }

        if(break1== -1 && break2 == -1) {
            System.out.println("Cant split the array into 3 parts");
            return;
        }

        System.out.println("Split array at "+ a[break1] +" location and " + a[break2]+ " location");
    }
}
