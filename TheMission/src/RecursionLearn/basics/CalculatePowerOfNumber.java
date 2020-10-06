package RecursionLearn.basics;

public class CalculatePowerOfNumber {
    public static void main(String[] args) {
        int x =2;
        int n = 3;
        //Calculate x^n; //2 ^ 3 = 8;

        int ans = findPowerIter(x,n);
        int ans2 = findPowerRec(x,n);
        System.out.println(ans);
        System.out.println(ans2);
    }


    public static int findPowerRecSmarter(int x , int n) {
        if(n ==0 ) return 1;

        if(n %2 == 0) {
            int y = x * findPowerRecSmarter(x, n/2);
            return y*y;
        }
        else {
            return x * findPowerRecSmarter(x, n-1);
        }
    }



    public static int findPowerRec(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * findPowerRec(x,n -1);
    }


    public static int findPowerIter(int x, int n) {
        int ans = 1;
        for(int i=1;i<=n;i++) {
            ans = ans * x;
        }
        return ans;
    }

}
