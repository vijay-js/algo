package BinarySearch;

public class FloorInASortedArray {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,8,10,10,12,19};
        int n = 0;
        int f = floor(a, n);
        if(f == Integer.MIN_VALUE) {
            System.out.println("No floor");
        }
        else {
            System.out.println("floor is " +f);
        }
    }

    private static int floor(int a[],int n) {
        int floor = Integer.MIN_VALUE;

        int low = 0;
        int high = a.length -1;

        while(low <=high) {
            int mid = low + (high -low)/2;

            if(a[mid] == n) {
                return a[mid];
            }
            else if(a[mid] < n) {
                floor = Math.max(floor,a[mid]);
                low = mid +1;
            }
            else {
                high = mid -1;
            }

        }
        return floor;
    }
}
