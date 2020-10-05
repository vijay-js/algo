package RecursionLearn.basics;

import Logger.Log;

public class PrintNumbers {

    public static void main(String[] args) {
//        fun(3);
//        PrintNto1(4);
//        Print1toN(4);
        Print1toNTailRecursive(4,1);
    }

    public static void fun(int n) {
        if(n < 1) {
            return;
        }

        Log.write(n);

        fun(n-1);
        Log.write(n);

    }



    public static void Print1toN(int n) {
        if(n ==0) {
            return;
        }

        Print1toN(n-1);
        Log.write(n);
    }

    public static void Print1toNTailRecursive(int n , int start) {

        if(start > n) {
            return;
        }
        Log.write(start);

        Print1toNTailRecursive(n, start+1);
    }
}
