package Graph;

public class Tests {
    public static void main(String[] args) {

        learnLoops();

    }

    public static boolean learnLoops() {
        for(int i =1;i<=10;i++) {
            System.out.println("Processinng " + i);
            if(i == 7) {
                return true;
            }
        }
        return false;
    }
}
