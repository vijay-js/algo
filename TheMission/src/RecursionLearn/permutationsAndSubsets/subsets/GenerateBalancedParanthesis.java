package RecursionLearn.permutationsAndSubsets.subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParanthesis {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        generate( list, "",0,0,6);
        for(String s: list) {
            System.out.print(s + " ");
        }
    }


    //( 1 0 3
    //(( 2 0 2   ()1 1 2
    //(() 2 1 1
    public static void generate(List<String> list,String temp,int open,int closed,int n) {
       if(n ==0 ) {
           list.add(temp);
           return;
       }


       //Also when sufficient closed braces are there we have 2 choices either open or closed
       if(closed > open) {

               generate(list,temp+")",open,closed+1,n-1);
               generate(list,temp+"(",open+1,closed,n-1);

       }
       else {
           generate(list,temp+"(",open+1,closed,n-1);
       }

    }
}
