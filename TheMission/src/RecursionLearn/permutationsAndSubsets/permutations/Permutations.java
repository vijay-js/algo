package RecursionLearn.permutationsAndSubsets.permutations;

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
//        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
//        System.out.print("Here are all the permutations: " + result);
        String str = "abcd";
        findPermsRec(str,"",str.length());
    }

    public static void findPermsRec(String str,String output,int size) {
        if(output.length() == size) {
            System.out.print(output + " ");
            return;
        }
        for(int i=0;i<str.length();i++) {
            findPermsRec(str.substring(0,i)+str.substring(i+1),output+str.charAt(i),size);
        }

    }

    public static void findPermsIter(String str) {
        Queue<String> queue = new LinkedList<>();

        for(int i=0;i<str.length();i++) {
            
        }
    }
}
