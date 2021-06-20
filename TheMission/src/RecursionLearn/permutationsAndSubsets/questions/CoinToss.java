package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoinToss {
    public static void main(String[] args) {
        coinTossOutComes(3,"");

//        List<String> outcomes = coinTossIter(3);
//
//        System.out.println();
//        for(String o:outcomes) {
//            System.out.print(o + " ");
//        }

        System.out.println();

//        coinToss(3,"");
        solveIterBetter(3);
    }

    public static void coinTossOutComes(int n, String output) {
        if(n ==0) {
            System.out.print(output + " ");
            return;
        }
        coinTossOutComes(n-1,output+"H");
        coinTossOutComes(n-1,output+"T");
    }

    public static List<String> coinTossIter(int n) {
        List<String> ans = new ArrayList<>();
        if(n>1) {
            ans.add("H");
            ans.add("T");
            n--;
        }
        for(int i=0;i<n;i++) {
            int size = ans.size();

            for(int j=0;j<size;j++) {
                String s= ans.get(j);
                StringBuilder sb1= new StringBuilder(s);
                StringBuilder sb2 = new StringBuilder(s);

                sb1.append("H");
                sb2.append("T");

                ans.set(j,sb1.toString());
                ans.add(sb2.toString());

            }
        }
        return ans;
    }


    public static void solveIterBetter(int n) {

        Queue<String> list = new LinkedList<>();
        list.add("");

        while(!list.isEmpty()) {

            String curr = list.poll();

            if(curr.length() == n) {
                System.out.print(curr + " ");
                continue;
            }
            else {
                list.add(curr + "H");
                list.add(curr + "T");
            }

        }

    }
}
