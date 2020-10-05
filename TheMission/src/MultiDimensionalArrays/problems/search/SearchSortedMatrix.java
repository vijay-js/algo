package MultiDimensionalArrays.problems.search;
/*
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


 */
public class SearchSortedMatrix {

    public static void main(String[] args) {
        int a[][] = {   {1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,50}
                    };

        int n = 23;
        boolean isFound = searchInSortedMatrix(a,n);

        System.out.println(isFound);

    }

    private static boolean searchInSortedMatrix(int a[][], int n) {
        int left = 0;
        int right = a.length * a[0].length - 1;

        boolean isFound = false;
        while(left <= right) {
            int mid = left + (right - left)/2;

            int r = mid/a[0].length;
            int c = mid%a[0].length;
            if(a[r][c] == n) {
                isFound = true;
                break;
            }
            else if(a[r][c] > n) {
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        return isFound;
    }
}
