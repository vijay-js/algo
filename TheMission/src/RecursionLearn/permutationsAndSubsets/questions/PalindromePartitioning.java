package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> hey = partition("aab");
        System.out.println(hey);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(s,result,temp);
        return result;
    }

    public static void helper(String s,List<List<String>> result,List<String> temp) {

        if(s.length() ==0) {
            result.add(new ArrayList<String>(temp));
            return;
        }

        for(int i=1;i<=s.length();i++) {
            String comp = s.substring(0,i);
            String remaining = s.substring(i);

            if(isPalindrome(comp)) {
                temp.add(comp);
                helper(remaining,result,temp);
                temp.remove(temp.size() -1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
            if(s.length() == 0) return true;

            int x =  0;
            int y = s.length()-1;

            while(x<y) {
                if(s.charAt(x) !=s.charAt(y)) {
                    return false;
                }
                x++;
                y--;
            }

            return true;
        }

}
