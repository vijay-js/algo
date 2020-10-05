package BinarySearch;

public class PeakElementInUnsortedArray {
    public static void main(String[] args) {

        int a[] = {10,20,15,5,23,90,67};

        System.out.println(findOnePeak(a));
    }

    private static int findOnePeak(int a[]) {
        int low = 0;
        int high = a.length -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            int prev = mid - 1 < low ? low : mid-1;
            int next = mid + 1 > high ? high : mid + 1;

            if(a[mid] >= a[prev] && a[mid] >= a[next]) {
                return mid;
            }
            else if(a[prev] > a[mid]) {
                high = mid -1;
            }
            else {
                low = low +1;
            }

        }
        return -1;
    }
}
