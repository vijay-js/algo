package ArraysLearn.InterviewPrep.subArray.KadanesAlgoMaxSubArraySum;
// Given an array of integers and an integer value k - find out k nonoverlapping sub arrays which have k maximum sums

public class kMaxSumsNonOverLappingSubArray {
    public static void main(String[] args) {
        int a[]= {3,2,1,-1,-2,-7,5,2,-6,-3};
        int k =3;
        getKNonOverLappingMaxSums(a,k);
    }

    private class SubArray {
        int start;
        int end ;
    }

    //We insert in heap the data structure of sum::indices . Pick top k for the answer
    private static  void getKNonOverLappingMaxSums(int a[], int k) {
        if (k > a.length) {
            throw new AssertionError("Cant split array into " + k + " sub arrays");
        }

        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end =0;

        for(int i=0;i<a.length;i++) {
            sum = sum + a[i];

            if(sum <=0) {
                start = i+1;
                sum = 0;
            }
        }


    }
}
