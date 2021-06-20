package RecursionLearn.permutationsAndSubsets.permutations;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a string, find all of its permutations preserving the character sequence but changing case.

Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52"

Input: "ab7c"
Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"

* */
public class PermutationPreservingCharSequenceButCaseChange {

    public static void main(String[] args) {
        String str = "ab7c";
        solveRec(str,"",0);
        System.out.println("********");
        System.out.println("********");
        solveIter(str);

        System.out.println("********");
        System.out.println("********");

        System.out.println("********");
        System.out.println("********");

        solveIterBetter(str);
    }


    public static void solveRec(String str,String output,int index) {
        if(index == str.length()) {
            System.out.print(output + " ");
            return;
        }
        char curr = str.charAt(index);
        boolean isDigit = Character.isDigit(curr);
        if(isDigit) {
            solveRec(str,output+curr,index+1);
        }
        else {
            solveRec(str,output+Character.toLowerCase(curr),index+1);
            solveRec(str,output+Character.toUpperCase(curr),index+1);
        }
    }

    public static void solveIter(String str) {

        int len = str.length();

        Queue<String> ans = new LinkedList<>();

        ans.add("");

        while (!ans.isEmpty()) {

            String cur = ans.peek();

            if(cur.length() == len) {
                System.out.print(ans.poll() + " ");
                continue;
            }

            int size = ans.size();
            char c = str.charAt(0);
            boolean isDigit = Character.isDigit(c);
            for(int i=0;i<size;i++) {
                String curr = ans.poll();
                if(isDigit) {
                    ans.add(curr+c);
                }
                else {
                    ans.add(curr+Character.toLowerCase(c));
                    ans.add(curr+Character.toUpperCase(c));
                }
            }





            str = str.substring(1);

        }

    }

    public static void solveIterBetter(String str) {

        Queue<String> ans = new LinkedList<>();
        ans.add("");

        for(char c: str.toCharArray()) {

            boolean isDigit = Character.isDigit(c);

            //Loop through current list
            int size = ans.size();
            for(int i=0;i<size;i++) {
                String curr = ans.poll();
                if(isDigit) {
                   ans.add(curr+c);
                }
                else {
                    ans.add(curr+Character.toLowerCase(c));
                    ans.add(curr+Character.toUpperCase(c));
                }
            }

        }

        for(String s : ans) {
            System.out.print(s + " ");
        }

    }


}
