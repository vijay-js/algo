package ArraysLearn.basic;

import ArraysLearn.ArrayHelper;

public class RotateArray {

    public static void main(String[] args) {
//        int a[] = ArrayHelper.generateRandomArray(10);
//
//        ArrayHelper.printArray(a);
//
//        int newArray[] = rotateArray(a,2);
//        ArrayHelper.printArray(newArray);


        int b[] = ArrayHelper.generateSequenceArray(10);
        ArrayHelper.printArray(b);
        rotate(b,6);
        ArrayHelper.printArray(b);



    }

    //Naive Way . Instead reverseArray twice and finally revserAgain
    private static int[]  rotateArray(int a[],int d) {
        int len = a.length;
        int a2[] = new int[len];
        int i=0;
        while(i<len-d) {
            a2[i] = a[d+i];
            i++;
        }
        int j=0;
        while(j<d && i < a.length) {
            a2[i] = a[j];
            j++;
            i++;
        }
        return  a2;
    }

    private static void rotate(int a[],int d) {
        d = d%a.length;
        reverseArray(a,0,d-1);
        reverseArray(a,d,a.length-1);
        reverseArray(a,0,a.length-1);
    }

    private static void reverseArray(int a[], int start,int end) {

        while(start<end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

    }


}
