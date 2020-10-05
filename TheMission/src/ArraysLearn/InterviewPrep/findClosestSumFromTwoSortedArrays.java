package ArraysLearn.InterviewPrep;

public class findClosestSumFromTwoSortedArrays {
    public static void main(String[] args) {
        int a[] = {2,3,6,8};
        int b[] = {10,20,30,40,50,60};
        int s = 33;
        int n = findClosestSum(a,b,s);
        System.out.print(n);

    }


    private static int  findClosestSum(int a[], int b[], int s){
            int i = 0;
            int j = b.length -1;
            int min_sum = Integer.MAX_VALUE;
            int start = -1;
            int end = -1;
            while(i< a.length && j >= 0) {
                if(Math.abs(a[i] +b[j] - s) < min_sum) {
                    min_sum= Math.abs(a[i] +b[j] - s);
                    start = i;
                    end = j;
                }
                if(a[i] + b[j] > s) {
                    j--;
                }
                else {
                    i++;
                }
            }
            return min_sum;
    }
}
