package ArraysLearn.basic;

import ArraysLearn.ArrayHelper;

public class ReverseAnArray {

    public static void main(String[] args) {
        int a[] = ArrayHelper.generateRandomArray(10);

        ArrayHelper.printArray(a);

        reverseArray(a);
        ArrayHelper.printArray(a);

    }


    public static void reverseArray(int a[]) {

        int i =0 , j = a.length-1;

        while(i<j) {
            swap(a,i,j);
            i++;
            j--;
        }


    }


    public static void swap(int a[],int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }

    public static void reverseArray1(int a[]) {
        for(int i=0;i<a.length/2;i++) {
            swap(a,i,a.length-i-1);
        }
    }
}
