package Heaps.questions;

import java.util.Comparator;
import java.util.PriorityQueue;
//
////Given an array and value x -> Find k closest values of x in the array


public class KClosestElements  {

    static class MyPair{
        int value;
        int index;

        MyPair(int value,int index) {
            this.value = value;
            this.index = index;
        }

    }
    public static void main(String[] args) {
        int a[] = new int[] {100,80,10,5,70};
        int k = 3;
        int n = 2;
        solve(a,k,n);
    }

    public static void solve(int a[],int k, int n) {
        PriorityQueue<MyPair> pq = new PriorityQueue<>( new Comparator<MyPair>() {


            @Override
            public int compare(MyPair o1, MyPair o2) {
                return o2.value - o1.value;
            }
        });

        for(int i=0;i<k;i++) {
            pq.add(new MyPair(Math.abs(a[i]-n),i));
        }

        for(int i=k;i<a.length;i++) {
           if(Math.abs(a[i]-n) < pq.peek().value) {
               pq.poll();
               pq.add(new MyPair(Math.abs(a[i]-n),i));
           }
        }

        while(!pq.isEmpty()) {
            System.out.print(a[pq.poll().index]+ " ");
        }
    }
}
