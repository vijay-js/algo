package effectiveJava.objectCreationPattterns.singleton;

public class Elvis {

    //Pub
    private String name;
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }



    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;

    }
}
