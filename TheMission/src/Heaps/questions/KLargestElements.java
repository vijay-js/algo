package Heaps.questions;

import java.util.Collections;
import java.util.PriorityQueue;

//Print K largest elements in unsorted array

public class KLargestElements {


    //O(k + (n-k)log k)
    public static int[] kLargestEfficient(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++) {
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++) {
            if(arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        int ans[] = new int[k];
       for(int i=0;i<k;i++) {
           ans[i] = pq.poll();
       }
       return ans;
    }


    //O(n + k logn )
    public static int[] kLargest(int arr[],int k)  {
        //Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++) {
            pq.add(arr[i]);
        }

        int i = 0;
        int[] ans = new int[k];
        while(i < k) {
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }



}
