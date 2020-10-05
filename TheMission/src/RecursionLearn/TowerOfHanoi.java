package RecursionLearn;

public class TowerOfHanoi {

    public static void main(String[] args) {
        TOH(3,'A','B','C');
    }

    public static void TOH(int n , char from, char to, char aux) {

        if(n ==0 ) {
            return;
        }

        TOH(n-1,from,aux,to);
        System.out.println("Move disk from " + from + " to " + to);
        TOH(n-1,aux,to,from);


    }
}
