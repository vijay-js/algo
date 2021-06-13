package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

//Given n opening braces and n closing braces generate balanced paranthesis
public class GenerateBalancedParanthesis {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int n = 3;
        generate(n,n,2*n,list,"");

        for(String s: list) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println();
        generateIterate(3);
    }

    public static void generate(int open,int closed,int n,List<String> list,String output) {
        if(open ==0 && closed ==0) {
            list.add(output);
            return;
        }

        if(open > n || closed > n) {
            return;
        }


        if(open >0) {
            generate(open-1,closed,n,list,output+"(");
        }
        if(closed > open ) {
            generate(open,closed-1,n,list,output+")");
        }

    }


    static class Quote {
        String current;
        int open;
        int closed;

        public Quote(String current,int open,int closed) {
            this.closed = closed;
            this.current = current;
            this.open = open;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "current='" + current + '\'' ;

        }
    }

    public static void generateIterate(int n) {

        Queue<Quote> ans = new LinkedList<>();
        ans.add(new Quote("(",1,0));

        while(!ans.isEmpty()) {


            //Go through all the current combinations and add open and closed
            Quote curr = ans.poll();

            if(curr.open == n && curr.closed == n) {
                System.out.print(curr.current + " ");
            }
            else {
                if(curr.open < n) {
                    ans.add(new Quote(curr.current+"(",curr.open+1, curr.closed));
                }
                if(curr.open > curr.closed) {
                    ans.add(new Quote(curr.current+")", curr.open, curr.closed+1));
                }
            }


        }


    }

}
