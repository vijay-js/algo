package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.List;

//Given n opening braces and n closing braces generate balanced paranthesis
public class GenerateBalancedParanthesis {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int n = 3;
        generate(n,n,2*n,list,"");
        for(String s: list) {
            System.out.print(s + " ");
        }
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



}
