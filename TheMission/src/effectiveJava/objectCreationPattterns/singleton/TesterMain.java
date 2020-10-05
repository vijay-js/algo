package effectiveJava.objectCreationPattterns.singleton;

public class TesterMain {

    public static void main(String[] args) {
        TheOne one = TheOne.getInstance("Vijay");
        TheOne two = TheOne.getInstance("Mani");
        System.out.println(one.hashCode());
        System.out.println(two.hashCode());
    }
}
