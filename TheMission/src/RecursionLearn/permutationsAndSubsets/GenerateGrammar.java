package RecursionLearn.permutationsAndSubsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateGrammar {

    public static void main(String[] args) {
        kthGrammar(5,1);
    }

//    0
//    0 1
//    0 1 1 0
//    0 1 1 0 1 0 0 1
//    0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0
    public static int kthGrammar(int N, int K) {
        List<Integer> answerList = new LinkedList<>();
        generateGrammar(N,answerList);
        answerList.forEach((x)-> System.out.print(x + " "));
        return answerList.get(K-1);
    }


    public static void generateGrammar(int N, List<Integer> list) {

        if (N==1) {
            list.add(0,0);
            return;
        }

        generateGrammar(N-1,list);


        for(int i=0;i<list.size();i = i+2) {
            if(list.get(i) ==0) {
                list.add(i+1, 1);
            }
            else {
                list.add(i+1, 0);
            }

        }
    }


    public static int getGrammar(int N,int K) {
        if(N==1) return 0;

        int lengthOfRow = (int)Math.pow(2,N-1);
        int mid = lengthOfRow/2;

        //It's same as prev Row.
        if(K<=mid) {
            return getGrammar(N-1,K);
        }

        else {
            int returnedVal = getGrammar(N-1,K-mid);
            return returnedVal == 0 ? 1 : 0;
        }

    }
}
