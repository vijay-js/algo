package RecursionLearn.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAnArray {
    public static void main(String[] args) {
        int a[] = {3,5,6,1,10,5};

        sortArray(a,a.length-1);


    }


    private static void insertIntoExactPositionInASortedArray(int el,int a[]) {
        int n = Arrays.binarySearch(a,el);

        if(n< 0) {
            n = -1 * (n+1);
        }

        a[n] = el;

    }


    private static void sortArray(int a[],int n) {

        if(a.length ==1) {
            return;
        }

        int element = a[n];
        sortArray(Arrays.copyOfRange(a,0,n),n-1);
        insertIntoExactPositionInASortedArray(element,Arrays.copyOfRange(a,0,n-1));
    }
}
