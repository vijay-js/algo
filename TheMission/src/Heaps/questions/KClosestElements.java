//package Heaps.questions;
//
//import java.util.Collections;
//import java.util.PriorityQueue;
//
////Given an array and value x -> Find k closest values of x in the array
//public class KClosestElements {
//
//    static class Pair {
//        int index;
//        int value;
//
//        Pair(int index,int value) {
//            this.index = index;
//            this.value = value;
//        }
//    }
//    public static void main(String args[]) {
//        int arr[] = new int[] {10,15,7,3,4};
//        int x = 8;
//        int k = 2;
//        kClosest(arr,x,k);
//    }
//    public static void kClosest(int arr[], int x, int k) {
//
//        int b[] = arr.clone();
//
//        for(int i=0;i<b.length;i++) {
//            b[i] = Math.abs(b[i]-x);
//        }
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder(),());
//
//        for(int i=0;i<k;i++) {
//            pq.add(new Pair(i,b[i]));
//        }
//
//        for(int i=k;i<b.length;i++) {
//            if(b[i] < pq.peek().value) {
//                pq.poll();
//                pq.add(new Pair(i,b[i]));
//            }
//        }
//
//        while (!pq.isEmpty()) {
//            System.out.print(arr[pq.poll().index] + x + " ");
//        }
//
//        System.out.println();
//
//    }
//}
