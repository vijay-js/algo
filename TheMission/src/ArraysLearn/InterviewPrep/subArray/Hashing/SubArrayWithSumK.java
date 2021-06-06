package ArraysLearn.InterviewPrep.subArray.Hashing;

//Key Idea is to find all the subarrys is prefixSum-k
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        int a[] = new int[] {3,4,7,2,-3,1,4,2};
        int k = 7;
        findSubArrayWithSumK(a,k);
    }

    private static void findSubArrayWithSumK(int a[], int k) {

        int sum  =0;
        Map<Integer, List<Integer>> prefixSum = new HashMap<>();
        //Counter for counting number of sub arrays with given prefix sum
        int count =0;

        for(int i=0;i<a.length;i++) {
            sum = sum + a[i];

            if(sum == k) {
                System.out.println("Sub Array with sum found from index 0 to index " + i);
                count++;
            }

            if(prefixSum.containsKey(sum-k)) {
                List<Integer> indices = prefixSum.get(sum-k);
                for(int j=0;j<indices.size();j++) {
                    int i1 = indices.get(j) + 1;
                    System.out.println("Sub Array with given sum exists between index "+i + " and index "+ i1);
                    count++;
                }
            }
            List<Integer> indexList = new ArrayList<>();
            if(prefixSum.containsKey(sum)) {
                indexList = prefixSum.get(sum);
            }
            indexList.add(i);
            prefixSum.put(sum,indexList);
        }

        System.out.println("Number of subarrays with sum "+k + "is "+ count );
    }
}
