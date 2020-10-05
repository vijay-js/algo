package BinarySearch.twoPointers;

import java.util.Arrays;
import java.util.Collections;

//a^2 + b^2 = c^2
public class FindPythogoreanTriplet {
    public static void main(String[] args) {
        Integer a[] = {3,1,4,6,5};
        Arrays.sort(a,Collections.reverseOrder());
        System.out.println(pythogoreanTrips(a));
    }

    private static boolean pythogoreanTrips(Integer a[]) {
        for (int i=0;i<a.length;i++) {
            a[i] = a[i] *a[i];
        }

        for(int i=0;i<a.length;i++) {
            if(findPair(a,i+1,a[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean findPair(Integer[] a, int start, int sum) {
        int low = start;
        int high = a.length -1;

        while(low < high) {
            if(a[low] + a[high] == sum) {
                return true;
            }
            else if (a[low] + a[high] > sum) {
                low++;
            }
            else {
                high--;
            }
        }
        return false;
    }
}
