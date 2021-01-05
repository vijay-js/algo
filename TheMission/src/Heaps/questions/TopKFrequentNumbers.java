package Heaps.questions;

import java.util.*;

public class TopKFrequentNumbers {

    static class Pair implements Comparable{
        int val;
        int freq;

        Pair(int val,int freq) {
            this.val = val;
            this.freq = freq;
        }


        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;
            return this.freq - p.freq;
        }
    }
    public static void main(String args[]) {
        int arr[] = new int[] {8,10,10,8,8,11,12,11,11,11,11,};
        getTopKFrequentNumbers(arr,1);
    }




    public static List<Integer>  getTopKFrequentNumbers(int arr[],int k) {
        Map<Integer,Integer> counts = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            counts.put(arr[i],counts.getOrDefault(arr[i],0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i: counts.keySet()) {
            if(pq.size() < k) {
                pq.add(new Pair(i,counts.get(i)));
            }
            else {
                if(counts.get(i) > pq.peek().freq) {
                    pq.poll();
                    pq.add(new Pair(i,counts.get(i)));
                }
            }

        }

        List<Integer> answer = new ArrayList<>();

        while(!pq.isEmpty()) {
            int val = pq.poll().val;
            System.out.print(val+ " ");
            answer.add(val);
        }
        System.out.println();
        return answer;
    }
}
