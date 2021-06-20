package RecursionLearn.permutationsAndSubsets.permutations;

import java.util.*;

public class Permutations {


    public static void main(String[] args) {
//        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
//        System.out.print("Here are all the permutations: " + result);
        String str = "abcd";
        System.out.println("***");
        findPermsRecSolve(str,"");
        System.out.println("***");
        System.out.println("***");
        findPermsIter(str);
    }

    public static void findPermsRecSolve(String str,String output) {

        if(str.length() == 0) {
            System.out.print(output + " ");
            return;
        }

        for(int i=0;i<str.length();i++) {
            findPermsRecSolve( str.substring(0,i)+str.substring(i+1),output+str.charAt(i));
        }

    }

    public static void findPermsIter(String str) {
        int len = str.length();

        Queue<String> ans = new LinkedList<>();

        ans.add(str.charAt(0)+"");
        str= str.substring(1);

        while(!ans.isEmpty()) {
            String curr = ans.peek();

            if(curr.length() == len) {
                System.out.print(ans.poll() + " ");
                continue;
            }
            //get all the current items in the list and loop over each item length and add at every position
            int size = ans.size();

            //Looping over all items
            for(int j=0;j<size;j++) {
                char currentChar = str.charAt(0);
                curr = ans.poll();
                //Looping over all positions
                for(int i=0;i<=curr.length();i++) {
                    String newone = curr.substring(0,i) + currentChar + curr.substring(i);
                    ans.add(newone);
                }
            }

            str = str.substring(1);


        }

    }

}
