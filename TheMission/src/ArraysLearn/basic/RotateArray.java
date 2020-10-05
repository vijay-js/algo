package ArraysLearn.basic;

import ArraysLearn.ArrayHelper;

public class RotateArray {

    public static void main(String[] args) {
        int a[] = ArrayHelper.generateRandomArray(10);

        ArrayHelper.printArray(a);

        int newArray[] = rotateArray(a,2);
        ArrayHelper.printArray(newArray);
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


}
