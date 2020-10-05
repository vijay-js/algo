package RecursionLearn.basics;

import Logger.Log;

public class Factorial {

    public static void main(String[] args) {

        Log.write(fact(4));
        Log.write(factTailRecurisve(4,1));


    }

    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }

        return n * fact(n-1);
    }


    public static int factTailRecurisve(int n, int result) {
        if(n ==0) {
            return result;
        }

        return factTailRecurisve(n-1,result*n);
    }
}

