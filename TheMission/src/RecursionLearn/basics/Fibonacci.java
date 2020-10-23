package RecursionLearn.basics;

import Logger.Log;

public class Fibonacci {
    public static void main(String[] args) {

        Log.write(fib(4));
        Log.write(factIter(4));

    }


    public static int fib(int n) {
        if(n ==0 || n ==1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int factIter(int n) {
        if(n == 0 || n == 1) return 1;
        int prev = 1;
        int current = 1;
        for(int i=2;i<=n;i++) {
            int temp = prev + current;
            prev = current;
            current = temp;
        }
        return current;

    }

}
