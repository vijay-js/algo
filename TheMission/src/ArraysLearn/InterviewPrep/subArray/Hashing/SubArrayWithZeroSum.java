package ArraysLearn.InterviewPrep.subArray.Hashing;

//Given an array - Find if there's a subarray with zero sum


import java.util.HashMap;
import java.util.Map;

/*
*  Key Idea here is to calculate prefix sum and see if the same prefix sum appears again. Which means there is subarray with Zero Sum
*
*
* */
public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int a[] = new int []{5,-3,-2,6};
        findIfZeroSumSubArray(a);

    }

    public static boolean findIfZeroSumSubArray(int a[]) {
        //Maintain hashmap of sum to index to get the final indices
        Map<Integer,Integer> map = new HashMap<>();

        //This is to handle when the subarray sum is zero which starts with first index.
        map.put(0,0);
        int prefix_sum = 0;

        for(int i=0;i<a.length;i++) {
            prefix_sum = prefix_sum + a[i];

            if(map.containsKey(prefix_sum)) {

                System.out.println("Sub array sum is zero between indices  " + (map.get(prefix_sum) + 1) + " " + (i));
                return true;
            }
            map.put(prefix_sum,i);
        }
        System.out.println("No sub array with zero sum");
        return false;
    }


    //Key Idea


}
