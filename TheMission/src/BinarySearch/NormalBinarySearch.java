package BinarySearch;

public class NormalBinarySearch {
    public static void main(String[] args) {
        int a[] = {2,4,6,8,10,11,15,60,78};

        int n = 2;

        binarySearchIter(a,2);
        boolean exists = binarySearchRecursive(a,0,a.length-1,2);
        System.out.println(exists);
    }

    private static boolean binarySearchIter(int a[], int n) {
        int low = 0;
        int high = a.length -1;

        while(low <=high) {
            int mid = low + (high - low)/2;

            if(a[mid] == n) {
                System.out.println("Found element at index "+mid);
                return true;
            }
            else if(a[mid] > n) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println("No element");
        return false;
    }


    private static boolean binarySearchRecursive(int a[], int start, int end,int n) {
        if(start > end ) return false;
        int mid = start + (end-start)/2;
        if(a[mid] == n) return true;
        else if(a[mid] > n) return binarySearchRecursive(a,start,mid -1,n);
        else return binarySearchRecursive(a,mid+1, end,n);
    }
}
