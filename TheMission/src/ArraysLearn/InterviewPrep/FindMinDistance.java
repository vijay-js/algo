package ArraysLearn.InterviewPrep;
/*
* Given an unsorted array of integers which has duplicates and two numbers x and y . Find the min distance between x and y in the array
*
*
* */
public class FindMinDistance {
    public static void main(String[] args) {
        int a[] = new int[] {3,5,4,2,6,5,3};
        int x = 6;
        int y = 3;

        System.out.println(solve(a,x,y));
    }

    private static int solve(int a[],int x,int y) {
        //first find till the first occurence of x or y
        int i=0;
        int prev = -1;
        int minDistance = Integer.MAX_VALUE;
        for(;i<a.length;i++) {
            if(a[i] == x || a[i] == y) {
                prev = i;
                break;
            }
        }

        for(;i<a.length;i++) {

            if(a[i] == x || a[i] == y) {
                if(a[prev] == a[i]) {
                    prev = i;
                }
                else {
                    minDistance = Math.min(minDistance,Math.abs(i-prev));
                    prev = i;
                }
            }

        }
        return minDistance-1;

    }

}
