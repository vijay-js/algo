package BinarySearch;

//The Key finding for this problem is post Binary search => the low and high points to the two adjacent values
//of the element if it needs to be inserted.
// So just do Binary Search
public class MinimumDifferenceElementInSortedArray {
    public static void main(String[] args) {
        int a[] = {1,3,8,10,15};
        int n = 15;

        int ans = findMinDifference(a,n);

        if(ans == 0 ) System.out.println( Math.abs(n - a[ans]));
        else if(ans == a.length ) System.out.println(Math.abs(n - a[ans-1]));
        else {
            int res = Math.min(Math.abs(n-a[ans]) , Math.abs(n-a[ans-1]));
            System.out.println(res);
        }

    }

    private static int findMinDifference(int a[], int n) {
        int low = 0;
        int high = a.length -1;
//        int index = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(a[mid] == n) return mid;

            else if(a[mid] > n) {
                high = mid -1;
            }
            else {
                low = mid +1;
            }

        }
        return low;
    }
}
