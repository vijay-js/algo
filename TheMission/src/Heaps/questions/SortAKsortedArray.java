package Heaps.questions;

import java.util.PriorityQueue;

//K -sorted Array means
//An element at index i will be present between the indices i-k and i+k in the sorted array
public class SortAKsortedArray {

    public static void sortKSorted(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++) {
            pq.add(arr[i]);
        }

        int index = 0;

        for(int i = k+1;i<arr.length;i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while(!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }

    }
}
