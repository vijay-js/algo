package dynamicprogramming.knapsack;

public class ZeroOneKnapsack {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int weights[] = new int[] {10,20,30};
        int val[] = new int[] {60,100,120};
        int maxWeight = 50;

        getMaxWeight(weights,val,maxWeight,0,0);
        System.out.println(max);

        int memo [][] = new int[maxWeight+1][weights.length+1];

        for(int i=0;i<=maxWeight;i++) {
            for(int j=0;j<=weights.length;j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(getMaxProfit(weights,val,maxWeight,weights.length,memo));

    }

    public static void getMaxWeight(int w[], int val[],int maxWeight,int index,int maxVal) {


        if(index == w.length || maxWeight == 0) {
            max = Math.max(max,maxVal);
            return;
        }



        if(maxWeight-w[index] >= 0) {
            getMaxWeight(w,val,maxWeight-w[index],index+1,maxVal+val[index]);
        }
        getMaxWeight(w,val,maxWeight,index+1,maxVal);
    }


    public static int getMaxProfit(int w[],int val[],int weight,int n,int [][]memo) {



        if(n ==0 || weight ==0) {
            return 0;
        }

        if(memo[weight][n] != -1) {
            return memo[weight][n];
        }

        int ans;
        if(w[n-1] <= weight) {
            ans = Math.max(val[n - 1] + getMaxProfit(w, val, weight - w[n - 1], n - 1, memo), getMaxProfit(w, val, weight, n - 1, memo));
        }

        else  {
            ans = getMaxProfit(w, val, weight, n - 1, memo);
        }
        memo[weight][n] = ans;
        return ans;

    }


//    public int bottomUp(int[] w,int [] v, int maxWeight) {
//
//        int dp[][] = new int[w.length+1][maxWeight+1];
//
//        for(int i=0;i<=w.)
//
//    }
}
