package ArraysLearn;


import java.util.Random;

public class ArrayHelper {

    public static void printArray(int a[]) {
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static int[] generateSequenceArray(int n) {
        int a[] = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = i+1;
        }
        return a;
    }


    public static int[] generateRandomArray(int n) {
        int a[] = new int[n];
        for(int i=0;i<n;i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        return a;
    }
}
