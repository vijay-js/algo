package ArraysLearn.InterviewPrep.slidingWindow;

public class SubArrayWithGivenSumNonNegative {

    public static void main(String[] args) {
        int a[] = {38,1,4,20,33,10,5};
        int sum = 33;

        boolean answer = doesSumExist(a,sum);

    }

    private static boolean doesSumExist(int a[], int sum) {
        if(a.length < 1) {
            return  false;
        }


    return true;

    }
}
