package RecursionLearn.permutationsAndSubsets.subsets;
//
//      Given a set with distinct elements, find all of its distinct subsets.
//
//        Example 1:
//
//        Input: [1, 3]
//        Output: [], [1], [3], [1,3]
//
//        Example 2:
//
//        Input: [1, 5, 3]
//        Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]

import Logger.Log;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfNumbers {

    public static void main(String[] args) {
        Log.write(findSubsets(new int[] {1,5,3}));
        RecursiveFindSubsets(new int[] {1,5,3}, new ArrayList<>(), 0);
    }

    public static List<List<Integer>> findSubsets(int arr[]) {

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());


        for(int i=0;i<arr.length;i++) {

            int currentSubsetSize = subsets.size();

            for(int j=0;j<currentSubsetSize;j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(arr[i]);
                subsets.add(set);
            }

        }

        return subsets;

    }


    public static void RecursiveFindSubsets(int arr[], List<Integer> current, int index) {

        if(index == arr.length) {
            System.out.print(current + " , ");
            return;
        }

        List<Integer> currentArray = new ArrayList<>(current);
        currentArray.add(arr[index]);

        RecursiveFindSubsets(arr,current,index+1);
        RecursiveFindSubsets(arr,currentArray,index+1);



    }
}
