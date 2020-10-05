package BinarySearch;

//If there are duplicates -> Cant be done in O(log n) -> Only O(n)
public class SearchInCircularSortedArray {
    public static void main(String[] args) {
        int a[] = {11,12,15,18,2,5,6,8};

        int n = 8;
        System.out.println(findElementInCircular(a,n));
    }

    private static int findElementInCircular(int a[], int n) {
        int low = 0;
        int high= a.length -1;

        while(low <=high) {
            int mid = low + (high-low)/2;

            if(a[mid] == n) return mid;

            else if (a[high] >= a[mid]) {
                if(n > a[mid] && n <=a[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid -1;
                }
            }
            else {
                if(a[low]<=n && n < a[mid]) {
                    high = mid -1;
                }
                else {
                    low = mid + 1;

                }
            }
        }
        return -1;
    }
}
