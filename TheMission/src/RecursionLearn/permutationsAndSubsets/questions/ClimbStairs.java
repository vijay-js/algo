package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.List;

public class ClimbStairs {
    public static void main(String[] args) {
        //POssiblities to reach nth stair with 1,2,3 steps avaiable

        climbStairs(5,"");

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


}
