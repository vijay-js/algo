package Heaps.questions;

import java.util.PriorityQueue;

/*
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope
with minimum cost. The cost of connecting two ropes is equal to the sum of their lengths.


Input: [1, 3, 11, 5]
Output: 33
Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)

* */
public class ConnectRopesWithMinCost {
    public static void main(String[] args) {
        int arr[] = new int[] {1,3,11,5};

        findMin(arr);
    }

    public static int findMin(int a[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<a.length;i++) {
            pq.add(a[i]);
        }
        int cost = 0;
        while(pq.size() > 1) {
            int rope1 = pq.poll();
            int rope2 = pq.poll();

            int newrope = rope1+rope2;
            pq.add(newrope);
            cost +=newrope;
        }

        System.out.println(cost);
        return cost;

    }
}
