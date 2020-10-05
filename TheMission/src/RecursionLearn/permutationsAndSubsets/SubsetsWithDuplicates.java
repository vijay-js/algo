package RecursionLearn.permutationsAndSubsets;


/*
    Given a set of numbers that might contain duplicates, find all of its distinct subsets.


Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]

[[], [1], [3], [1, 3], [3, 3], [1, 3, 3]]





Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
        [], [1], [5], [1, 5], [3], [1, 3], [5, 3], [1, 5, 3], [3, 3], [1, 3, 3], [5, 3, 3], [1, 5, 3, 3]


*/

import Logger.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {
    public static void main(String[] args) {
        Log.write(findSubsWithoutDups(new int[] {1,5,3,3}));
        Log.write(findWithoutSubsAfterSorting(new int[] {1,5,3,3}));
    }


    public static List<List<Integer>> findSubsWithoutDups(int a[]) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(int i=0;i<a.length;i++) {

            int subSetSize = subsets.size();

            for(int j=0;j<subSetSize;j++) {

                List<Integer> set = new ArrayList<>(subsets.get(j));

                set.add(a[i]);

                //Check for duplicates
                if(!subsets.contains(set)) {
                    subsets.add(set);
                }
            }


        }
        return subsets;
    }


    public static List<List<Integer>> findWithoutSubsAfterSorting(int a[]) {

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        if(a.length <=0) return subsets;

        List<Integer> firstElement = new ArrayList<>();
        firstElement.add(a[0]);

        subsets.add(firstElement);



        Arrays.sort(a);

        int prev = a[0];
        int numSubSetsGenerated = 0;

        int startIndex = 0;

        for(int i=1;i<a.length;i++) {

            if(a[i] == a[prev]) {
                //If previous  element is same - generate only for the previously genetated substrings
                startIndex = numSubSetsGenerated;
                numSubSetsGenerated = 0;
            }
            else {
                startIndex = 0;
                numSubSetsGenerated = 0;
            }

            int subSetSize = subsets.size();

            for(int j=startIndex;j<subSetSize;j++) {
                numSubSetsGenerated ++;
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(a[i]);
                subsets.add(set);
            }

            a[prev] = a[i];



        }

        return subsets;
    }
}
