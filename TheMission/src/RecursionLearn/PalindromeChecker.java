package RecursionLearn;

import Logger.Log;

public class PalindromeChecker {

    public static void main(String[] args) {
       Log.write(isPalindrome("abba", 0,"aabb".length()-1));
//        Log.write(isPalindrome("abba", 0,"aabb".length()-1));
//        Log.write(isPalindrome("aaaaa", 0,"aaaaa".length()-1));
//        Log.write(isPalindrome("ababa", 0,"ababa".length()-1));
//        Log.write(isPalindrome("abcaba", 0,"ababa".length()-1));
    }


    public static boolean isPalindrome(String str, int start,int end) {
        if(start >= end) {
            return true;
        }


        if(str.charAt(start) == str.charAt(end)) {
            System.out.println(str.charAt(start) + " " + str.charAt(end));
           boolean isPal = isPalindrome(str, ++start, --end);

           return isPal;
        }
        return false;
    }
}
