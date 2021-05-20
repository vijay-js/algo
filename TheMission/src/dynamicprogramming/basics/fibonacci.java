package dynamicprogramming.basics;

import java.util.Arrays;

public class fibonacci {
    public static void main(String[] args) {
        int n = 10;

        int memo[] = new int[n+1];

        Arrays.fill(memo,-1);
        int res = fibMemo(n,memo);
        System.out.println(res);
        int res2 = fibTabulation(n);
        System.out.println(res2);
        fibTab(n);
    }

    private static int fibMemo(int n,int memo[]) {



        if(memo[n] == -1) {
            int res;
            if(n ==0 || n ==1) {
                res = n;
            }
            else {
                res= fibMemo(n-1,memo) + fibMemo(n-2,memo);
            }

            memo[n] = res;
        }
        return memo[n];
    }


    private static int fibTabulation(int n) {
        if(n ==0 || n ==1) return n;
        int curr = 1;
        int prev = 0;
        int res = -1;
        int x = 2;
        while(x <=n) {
            res = curr + prev;
            int temp = curr;
            curr = res;
            prev = temp;
            x++;
        }
        return res;
    }

    private static int fibTab(int n) {
        int fib[] = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;

        for(int i=2;i<=n;i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}
