package ArraysLearn.InterviewPrep.slidingWindow;

import java.util.*;

public class CountDistinctElementsInEveryWindowForK {
    public static void main(String[] args) {
        int a[]= {1,2,1,3,4,2,3};
        int k =4;

        List<Integer> distinctElements = findDistinctElementsInEveryWindowOfSizeK(a,k);

        for(int count: distinctElements) {
            System.out.print(count + " ");
        }
        System.out.println();
    }


    private static List<Integer> findDistinctElementsInEveryWindowOfSizeK(int a[], int k) {

        if(k > a.length) {
            throw new AssertionError("The array should be larger than the window size");
        }
        HashMap<Integer,Integer> distinctElements = new HashMap<>();
        List<Integer> countOfDistinctElements = new ArrayList<>();


        for(int i=0;i<k;i++) {
            distinctElements.put(a[i],distinctElements.getOrDefault(a[i],0) +1);
        }
        countOfDistinctElements.add(distinctElements.size());

        for(int i=k;i<a.length;i++) {
            if(distinctElements.get(a[i-k]) ==1 ) {
                distinctElements.remove(a[i-k]);
            }
            else {
                distinctElements.put(a[i-k],distinctElements.get(a[i-k]) -1);
            }
            distinctElements.put(a[i],distinctElements.getOrDefault(a[i],0)+1);
            countOfDistinctElements.add(distinctElements.size());
        }
        return countOfDistinctElements;


    }
}
