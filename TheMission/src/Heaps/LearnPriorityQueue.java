package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LearnPriorityQueue {
    public static void main(String args[]) {
        //
        PriorityQueue<Integer> pq = new PriorityQueue<>(2);

        //MAX HEAP
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(20);
        pq.add(15);

        //Top of Min hEap ==>  10
        System.out.println(pq.peek());

        System.out.println(pq.poll());

        //15 as its heapified after poll
        System.out.println(pq.peek());
    }
}
