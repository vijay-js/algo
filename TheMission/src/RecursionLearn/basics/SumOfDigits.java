package RecursionLearn.basics;

import Logger.Log;

public class SumOfDigits {
    public static void main(String[] args) {
        Log.write(sum(10,0));
    }


    public static int sum(int d, int result) {
        if(d ==0) {
            return result;
        }

        return sum(d/10,result + d%10);
    }
}
