package RecursionLearn;

public class JosepheusProblem {

    public static void main(String[] args) {

    }

    public static int winner(int n , int k) {

        if(n ==1) {
            return 1;
        }

        //Every time n%k + 1 is a winner - so we have to offset the loop each time by k
        return (winner(n - 1, k) + k-1) % n + 1;
    }



}
