package effectiveJava.objectCreationPattterns.singleton;

public class TheOne {

    private String name;

    private static TheOne INSTANCE;

    private TheOne() {

    }

    public static TheOne getInstance(String name) {
        if(INSTANCE == null) {
            INSTANCE = new TheOne(name);
        }
        return INSTANCE;
    }

    private TheOne(String name) {
        this.name = name;
    }

    public String screamName () {
        return "Screaming "+this.name;
    }
}

