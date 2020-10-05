package ArraysLearn.InterviewPrep;

//Easiest way is hashmap but

public class MajorityElement {
    public static void main(String[] args) {
        int a[] = {1,2,1,2,3};

        int i = findMajorityElement(a);

        System.out.println(i);

    }

    private static int findMajorityElement(int[] a) {

        if(a.length < 1) {
            return -1;
        }
        int element = a[0];
        int count = 1;
        for(int i=1;i<a.length;i++) {
            if(a[i] == element) {
                count++;
            }
            else {
                count--;
            }
            if(count == 0) {
                element = a[i];
                count =1;
            }
        }
        return element;
    }
}
