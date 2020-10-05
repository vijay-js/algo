package RecursionLearn;

import Logger.Log;

public class RopeCutting {

    public static void main(String[] args) {
        Log.write(cutRopes(5,2,2,3));
    }


    public static int cutRopes(int n , int a, int b , int c) {

        if(n==0) {
            //This is a valid cut;
            return 0;
        }

        if(n<0) {

            //Not a valid cut
            return -1;
        }

        int result = maxOf3(cutRopes(n-a,a,b,c) , cutRopes(n-b,a,b,c), cutRopes(n-c,a,b,c));

        if(result == -1) {
            return -1;
        }

        return result +1;
    }


    public static int maxOf3(int a, int b, int c) {
        if(a >=b & a>=c) {
            return a;
        }

        else if(b >=a && b>=c) {
            return b;
        }
        return c;
    }
}
