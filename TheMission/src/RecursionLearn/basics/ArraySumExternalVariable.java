package RecursionLearn.basics;

import Logger.Log;

public class ArraySumExternalVariable {

    public static class Result {
        int result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        Result r = new Result();
        SumOfElements(arr,0,r);
        Log.write(r.result);
    }




    public static void SumOfElements(int a[],int i, Result r) {
        if(a.length == i) return;
        r.result = r.result + a[i];
        SumOfElements(a,i+1,r);
    }
}
