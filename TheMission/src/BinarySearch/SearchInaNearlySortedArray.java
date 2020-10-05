package BinarySearch;

//KEY IDEA IS NEARLY SORTED ==> i , i-1, i-2
public class SearchInaNearlySortedArray {
    public static void main(String[] args) {
        int a[] = {10,5,30,20,40,60,87,78};
        int n = 87;
        int i = search(a,n);
        if(i == -1) {
            System.out.println("Element not present");
        }
        else{
            System.out.println("Element at index " + i);
        }

    }

    private static int search(int a[], int n) {
        int low = 0;
        int high = a.length -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(a[mid] == n) return mid;

            if(mid -1 >=0 && a[mid -1] == n) return mid -1;

            if(mid +1 <=a.length -1 && a[mid+1] == n) return mid+1;

            else if(a[mid] > n) {
                high = mid -2;
            }
            else {
                low = mid +2;
            }

        }
        return -1;
    }
}
