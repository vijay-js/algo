package BinarySearch;

//Number of times rotated == Index of min element
public class NumberOfTimesRotatedArray {
    public static void main(String[] args) {
        int a[] = {4,5,6,7,0,1,2};

        System.out.println(findIndexOfMinElement(a));
        System.out.println(findNumTimesRotated(a));

    }

    private static int findIndexOfMinElement(int a[]) {

        int low = 0;
        int n = a.length;
        int high = a.length -1;

        while(low <=high) {
            //Very important Condition -> If its already sorted => Return the first element
            if(a[low] <=a[high]) return low;

            int mid = low + (high-low)/2;
            int next = ( mid +1 )%n;
            int prev = (mid + n -1 ) %n;

            if(a[mid] <= a[next] && a[mid] <=a[prev]) {
                return mid;
            }
            //right half is sorted


            //left half is sorted
            else if(a[low] <= a[mid]) {
                low = mid +1;
            }
            else if(a[high] >=a[mid]) {
                high = mid -1;
            }
        }
        return -1;
    }

    private static int findNumTimesRotated(int a[]) {
        int low =0;
        int high = a.length -1;


        while(low <=high) {
            if(a[low] <=a[high]) return low;
            int mid = low + (high -low)/2;

            int prev = mid <= low ? a[mid] : a[mid-1];
            int next = mid >= high ? a[mid] : a[mid+1];

            if(a[mid] <= prev && a[mid] <= next) {
                return mid;
            }

            //Left half is sorted - Go to right half
            if(a[low] <= a[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

        }

        return -1;
    }
}
