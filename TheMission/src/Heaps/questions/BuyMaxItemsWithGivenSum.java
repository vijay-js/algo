package Heaps.questions;

import java.util.PriorityQueue;

public class BuyMaxItemsWithGivenSum {

    public int buyMaxItems(int a[],int sum) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(a.length);
        for(int i=0;i<a.length;i++) {
            pq.add(a[i]);
        }

        int items = 0;

        for(int i=0;i<a.length;i++) {
            if(pq.peek() <= sum) {
                sum = sum - pq.poll();
                items++;
            }
            else {
                break;
            }
        }
        return items;
    }
}
