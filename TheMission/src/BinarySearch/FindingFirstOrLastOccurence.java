package BinarySearch;

public class FindingFirstOrLastOccurence {
    public static void main(String[] args) {
        int a [] = {2,10,10,10,10,10,18,20};
        int n = 10;
        int i = findFirstOccurence(a,n);

        if(i == Integer.MAX_VALUE) {
            System.out.println("Cant find the element");
        }
        else{
            System.out.println("First Occurence at index " +i);
        }

        int j = findLastOccurence(a,n);

        if(i == Integer.MIN_VALUE) {
            System.out.println("Cant find the element");
        }
        else{
            System.out.println("Last Occurence at index " +j);
        }
    }

    private static int findFirstOccurence(int a[], int n) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = a.length -1;

        while(low <=high) {
            int mid = low + (high-low)/2;

            if(a[mid] == n) {
                ans = Math.min(ans,mid);
                high = mid -1;
            }
            else if(a[mid] > n) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findLastOccurence(int a[], int n) {
        int ans = Integer.MIN_VALUE;
        int low = 0;
        int high = a.length -1;

        while(low <=high) {
            int mid = low + (high-low)/2;

            if(a[mid] == n) {
                ans = Math.max(ans,mid);
                low = mid + 1;
            }
            else if(a[mid] > n) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
