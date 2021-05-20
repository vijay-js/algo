package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.List;

public class CoinToss {
    public static void main(String[] args) {
        coinTossOutComes(4,"");

        List<String> outcomes = coinTossIter(4);

        System.out.println();
        for(String o:outcomes) {
            System.out.print(o + " ");
        }
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

}
