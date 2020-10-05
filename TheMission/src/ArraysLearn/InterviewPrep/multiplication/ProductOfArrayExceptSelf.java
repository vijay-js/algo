package ArraysLearn.InterviewPrep.multiplication;

import ArraysLearn.ArrayHelper;


public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        //Left Array Product x Right Array Product
        int a[]= {1,0,4,5};
        ArrayHelper.printArray(a);

        productExceptSelf(a);

        ArrayHelper.printArray(a);
    }

    public static void productExceptSelf(int a[]) {
        if(a.length < 1) throw new AssertionError("Array cant be empty");
        int prevProductArr[] = new int[a.length];
        int nextProductArr[] = new int[a.length];

        prevProductArr[0] = 1;
        nextProductArr[a.length-1] = 1;

        for(int i=1;i<prevProductArr.length;i++) {
            prevProductArr[i] = prevProductArr[i-1] * a[i-1];
        }

        for(int j=a.length-2;j>=0;j--) {
            nextProductArr[j] = nextProductArr[j+1] * a[j+1];
        }

        for(int i=0;i<a.length;i++) {
            a[i] = prevProductArr[i] * nextProductArr[i];
        }



    }
}
