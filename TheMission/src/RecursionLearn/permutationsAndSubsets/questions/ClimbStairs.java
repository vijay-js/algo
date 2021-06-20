package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ClimbStairs {
    public static void main(String[] args) {
        //POssiblities to reach nth stair with 1,2,3 steps avaiable

        climbStairs(5,"");

        System.out.println();
        solveIter(5);
    }

    public static void climbStairs(int n,String output){
        if(n ==0) {
            System.out.print(output + " ");
        }
        if(n <0) {
            return;
        }

        climbStairs(n-1,output+"1");
        climbStairs(n-2,output+"2");
        climbStairs(n-3,output+"3");

    }

    static class StairCount {
        int count;
        String curr;

        public  StairCount(String curr, int count) {
            this.curr = curr;
            this.count = count;
        }
    }
    public static void solveIter(int n) {

        Queue<StairCount> ans = new LinkedList<>();
        ans.add(new StairCount("",0));

        while(!ans.isEmpty()) {

            StairCount curr = ans.poll();

            if(curr.count == n) {
                System.out.print(curr.curr + " ");
                continue;
            }

            if(curr.count > n) {
                continue;
            }

            ans.add(new StairCount(curr.curr+"1", curr.count+1));
            ans.add(new StairCount(curr.curr+"2", curr.count+2));
            ans.add(new StairCount(curr.curr+"3", curr.count+3));

        }


    }


}
