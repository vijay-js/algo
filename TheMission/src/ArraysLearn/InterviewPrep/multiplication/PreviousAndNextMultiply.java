package ArraysLearn.InterviewPrep.multiplication;

//Given an array of integers update every element with multiplying prev and next eleemnts.


import ArraysLearn.ArrayHelper;

//Key Idea is to store prev element while traversing any element as next element is gotten by a[i+1]
public class PreviousAndNextMultiply {
    public static void main(String[] args) {
        int a[]= {2,4,5,7,8};
        ArrayHelper.printArray(a);
         multiply(a); //8 10 28 40 56
        ArrayHelper.printArray(a);
    }

    private static void multiply(int a[]) {
        int prev = a[0];

        for(int i=0;i<a.length-1;i++) {
            int temp = a[i];
            a[i] = prev * a[i+1];
            prev = temp;
        }
        a[a.length-1] = prev * a[a.length-1];
    }

}
