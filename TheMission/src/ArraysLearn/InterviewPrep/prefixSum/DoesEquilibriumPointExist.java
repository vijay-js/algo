package ArraysLearn.InterviewPrep.prefixSum;

//Sum on left side of elements in array = Sum of right side elements in the array
public class DoesEquilibriumPointExist {
    public static void main(String[] args) {
        int a[] = new int[]{2,-2,4};

        getEquilibriumPoint(a);

    }

    //Use left sum variable for O(1) instead of maintaining the prefixSum

    private static void getEquilibriumPoint(int a[]) {
        if(a.length < 1) return;

        int totalSum = a[0];
        int prefixSum[] = new int[a.length];

        prefixSum[0] = a[0];

        for(int i=1;i<a.length;i++) {
            prefixSum[i] = prefixSum[i-1] + a[i];
            totalSum += a[i];
        }

        for(int i=0;i<a.length;i++) {
           int sumLeft = i ==0 ? 0 : prefixSum[i-1];
           int sumRight = i==a.length-1 ? 0 : totalSum - prefixSum[i];

           if(sumLeft == sumRight) {
               System.out.println("Equilibrium Point : " +a[i]);
           }

        }
    }
}
