package Heaps.questions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*

Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the
array such that we are left with maximum distinct numbers.

Input: [7, 3, 5, 8, 5, 3, 3], and K=2
Output: 3




* */
public class MaxDistinctElements {
    public static void main(String[] args) {
        int arr[]= new int[] {3, 5, 12, 11, 12};
        int k = 3;
        solve(arr,k);
    }

    public static int solve(int a[],int k ){
        int count =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++) {
            map.put(a[i],map.getOrDefault(a[i],0) +1);
        }

        map.entrySet();
        for(int i: map.keySet()) {
            if(map.get(i) == 1) {
                count++;
            }
            else {
                pq.add(map.get(i)-1);
            }
        }

        while(k>0 && !pq.isEmpty()) {
            if(pq.peek() <= k) {
                k = k - pq.poll();
                count++;
            }
            else {
                break;
            }
        }
        if(k > 0) {
            count= count - k;
        }
        System.out.println(count);
        return count;
    }
}
