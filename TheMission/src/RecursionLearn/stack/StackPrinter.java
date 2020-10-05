package RecursionLearn.stack;

import java.util.Stack;

public class StackPrinter {
    private StackPrinter() {

    }

    public static void print(Stack<Integer> s) {
        System.out.println("Stack Start");
        for(int i:s) {
            System.out.println(i);
        }
        System.out.println("Stack end");
    }

}
