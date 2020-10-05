package ArraysLearn.InterviewPrep.slidingWindow;

import java.util.*;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//        Input: S = "ADOBECODEBANC", T = "ABC"
//        Output: "BANC"
public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String S = "ADOBECODEBANC";
        String T = "ABC";

       String answer =  findMinWindowNaiveSubstring(S,T);

       String a = findWindowSubString(S,T);

       System.out.println(answer);
       System.out.println(a);
    }


    private static String findWindowSubString(String S, String T) {

        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();


        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequency of the Characters)
        Map<Character,Integer> map = new HashMap<>();
        for(Character t : T.toCharArray()) {
            map.put(t,map.getOrDefault(t,0) + 1);
        }

        //maintain a counter to check whether match the target string.
        //must be the map size, NOT the string size because the char may be duplicate.
        int counter = map.size();

        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;

        //To store starting point of the substring if match is found;
        int head = 0;

        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE;

        while(end < S.length()) {

            char s = S.charAt(end);

            if(map.containsKey(s)) {
                int freq = map.get(s);
                map.put(s,freq -1);
                if(freq -1 ==0) {
                    //One character all occurences exist
                    counter --;
                }
            }
            end ++;

            while(counter ==0) {
                //Found answer here -> Try to reduce the substrin

                if(end - begin < len) {
                    len = end -begin;
                    head = begin;
                }




                char temp = S.charAt(begin);

                if(map.containsKey(temp)) {
                    if(map.get(temp) == 0) counter++;
                    map.put(temp,map.get(temp) +1);
                }

                begin++;
            }

        }

        if(len == Integer.MAX_VALUE) return "";
        return S.substring(head, head+len);
    }














    private static String findMinWindowNaiveSubstring(String S, String T) {
        String answer = "";
        int min_length = Integer.MAX_VALUE;

        for(int i=0;i<S.length();i++) {
            StringBuilder sb = new StringBuilder();
            //for each character in I
            for(int j=i;j<S.length();j++) {
                sb.append(S.charAt(j));
                if(checkifAllCharsExist(sb.toString(),T)) {
                    min_length = Math.min(min_length,sb.toString().length());
                    if(min_length == sb.toString().length()) {
                        answer = sb.toString();
                    }
                }
            }

        }
        return answer;
    }

    private static boolean checkifAllCharsExist(String sb,String T) {

        Set<Character> set1 = stringToCharacterSet(sb);
        Set<Character> set2 = stringToCharacterSet(T);

        if(set1.containsAll(set2)) {
            return true;
        }
        return false;
    }

    private static Set<Character> stringToCharacterSet(String s) {
        Set<Character> set = new HashSet<>();
        for(char s1: s.toCharArray()) {
            set.add(s1);
        }
        return set;
    }
}
