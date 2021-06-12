package RecursionLearn.basics;

import Logger.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {

        Log.write(fib(10));
        Log.write(fibIter(10));
        Log.write(fibTail(5,0,1));
        Map<Integer,Integer> map = new HashMap<>(){{
            put(0,0);
            put(1,1);
        }};
        Log.write(fibCache(5,map ));


    }


    public static int fib(int n) {
        if(n ==0 || n ==1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fibCache(int n, Map<Integer,Integer> map) {
        if(n ==0 || n==1) return n;

        if(map.containsKey(n)) return map.get(n);

        int ans = fibCache(n-1,map) + fibCache(n-2,map);

        map.put(n,ans);
        return ans;
    }

    public static int fibTail(int n , int a, int b) {
        if(n ==0) return a;
        if(n ==1) return b;

        return fibTail(n-1,b,a+b);
    }


    public static int fibIter(int n) {
        if(n == 0 || n == 1) return n;
        int prev = 0;
        int current = 1;
        for(int i=2;i<=n;i++) {
            int temp = prev + current;
            prev = current;
            current = temp;
        }
        return current;

    }

}
