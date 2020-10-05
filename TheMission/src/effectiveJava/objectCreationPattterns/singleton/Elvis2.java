package effectiveJava.objectCreationPattterns.singleton;

public class Elvis2 {
    private static final Elvis2 INSTANCE = new Elvis2();

    private Elvis2() {
    }

    private static Elvis2 getINSTANCE() {
       return INSTANCE;
    }

    //TODO read this  journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#reflection-and-singleton
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis2 elvis2 = Elvis2.getINSTANCE();


    }
}
