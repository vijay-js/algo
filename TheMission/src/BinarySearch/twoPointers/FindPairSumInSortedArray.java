package BinarySearch.twoPointers;

public class FindPairSumInSortedArray {
    public static void main(String[] args) {
        int a[] = {2,4,8,9,11,12,20,30};

        int n =101;
        int[][] ans = findPairIndices(a,n);
        if(ans[0][1] == -1) {
            System.out.println("No pair found");
        }
        else {
            System.out.println("Indices : "+ ans[0][0] +" and " + ans[0][1]);
        }
    }

    private static int[][] findPairIndices(int a[],int n) {
        int ans [][] = new int[1][2];

        int left = 0;
        int right = a.length -1;

        while(left<right) {
            if(a[left] + a[right] == n) {
                ans[0] = new int[] {left,right};
                return ans;
            }
            else if(a[left] + a[right] > n) {
                right --;
            }
            else {
                left++;
            }
        }
        return new int[][]{{-1,-1}};
    }
}
