package BinarySearch.twoPointers;

//For unsorted array - sort and same logic :: better than hashing as there is no hashing computation
public class TripletSumInSortedArray {
    public static void main(String[] args) {
        int a[] = {2,3,4,8,9,20,40};
        int n = 122;

        int [][] ans = findTriplets(a,n);
        if(ans[0][0]== -1) {
            System.out.println("No triplets found");
        }
        else {
            System.out.println("Tripltes with indices at "+ ans[0][0] + " "+ ans[0][1]+ " "+ans[0][2]);
        }
    }

    private static int[][] findTriplets(int a[], int n) {
        for(int i=0;i<a.length;i++) {
            int remainingSum = n - a[i];
            int [][] pairs = findPair(a,i+1,remainingSum);
            if(pairs[0][1] == -1) {
                continue;
            }
            else {
                return new int[][] {{i,pairs[0][0],pairs[0][1]}};
            }
        }
        return new int[][]{{-1,-1,-1}};
    }

    private static int[][] findPair(int[] a, int start, int sum) {
        int low = start;
        int high = a.length -1;

        while(low < high) {
            if(a[low] + a[high] == sum) {
                return new int[][] {{low, high}};
            }
            else if (a[low] + a[high] > sum) {
                high--;
            }
            else {
                low++;
            }
        }
        return new int[][] {{-1,-1}};
    }
}
