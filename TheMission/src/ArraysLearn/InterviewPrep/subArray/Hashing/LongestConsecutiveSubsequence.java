package ArraysLearn.InterviewPrep.subArray.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an array of positive integers.
Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers,
the consecutive numbers can be in any order.

N = 7
a[] = {2,6,1,9,4,5,3}

* */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int a[] = new int[]{1,9,3,10,4,20,2};
        solve(a);
    }

    private static int solve(int a[]) {
        int ans = Integer.MIN_VALUE;
        Set<Integer> hs= new HashSet<>();

        for(int i=0;i<a.length;i++) {
            hs.add(a[i]);
        }

        for(int i=0;i<a.length;i++) {
            if(hs.contains(a[i]-1)) continue;
            int curr = a[i];
            int count = 0;
            while(hs.contains(curr)) {
                count++;
                curr++;
            }
            ans = Math.max(ans,count);
        }
        System.out.println("Longest Sequence is " + ans);
        return ans;
    }
}
