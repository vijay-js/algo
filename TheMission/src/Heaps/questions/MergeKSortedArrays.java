package Heaps.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static class Triplet implements Comparable<Triplet>{
        int val;
        int list;
        int index;

        Triplet(int val,int list,int index) {
            this.val = val;
            this.list = list;
            this.index = index;
        }

        @Override
        public int compareTo(Triplet o) {
            if(this.val >= o.val) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);

        List<Integer> res = mergeArr(arr);

        System.out.println("Merged array is " );
        for (int x : res)
            System.out.print(x + " ");
    }


    public static List<Integer> mergeArr(List<List<Integer>> arr) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        //first add all first elements to the queye

        for(int i=0;i<arr.size();i++) {
            pq.add(new Triplet(arr.get(i).get(0),i,0));
        }

        while(!pq.isEmpty()) {
            Triplet min = pq.peek();
            int list = min.list;
            int index = min.index;

            ans.add(pq.poll().val);

            if(index+1 < arr.get(list).size()) {
                pq.add(new Triplet(arr.get(list).get(index+1),list,index+1));
            }
        }

        return ans;

    }

}
