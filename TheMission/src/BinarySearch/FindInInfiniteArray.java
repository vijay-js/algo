package BinarySearch;

public class FindInInfiniteArray {
    public static void main(String[] args) {
        int a[] = { 1,4,6,7,8,9,11,16,31,35,43,47,55};
        int x = 11;
        findInInfiniteArr(a,x);
    }

    private static int findInInfiniteArr(int[] a, int x) {
        if(a[0] == x) return 0;

        int i =1;
        while(a[i] < x) {
            i = i* 2;
        }

        if(a[i] == x) return i;

//        else return binarySearch(a,i/2,i,x);
        return -1;
    }
}
