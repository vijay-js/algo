package MultiDimensionalArrays.problems.search;

import MultiDimensionalArrays.helper;

public class SearchInRowWiseColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int a[][] = {   {1,3}
                    };

        helper.printArray(a);

        int n = 3;
        searchInMatrix(a,n);
    }

    private static void searchInMatrix(int a[][], int n) {

        boolean isFound = false;

        int r = 0;
        int c = a[0].length -1;

       while(r <a.length  && c>=0 ) {
           if(a[r][c] == n) {
               isFound = true;
               break;
           }
           else if(a[r][c] > n) {
               c--;
           }
           else {
               r++;
           }
       }

       System.out.println("The element "+ n + "is present ::" + isFound);


    }
}
