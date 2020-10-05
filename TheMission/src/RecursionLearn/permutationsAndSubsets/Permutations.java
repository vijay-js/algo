package RecursionLearn.permutationsAndSubsets;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 1) return result;


        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());


        for(int i=0;i<nums.length;i++) {

           int n = permutations.size();
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
