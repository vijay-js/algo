package RecursionLearn.stack;

import java.util.Stack;

public class SortStackByRecursion {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(6);
        s.push(5);
        s.push(10);
        s.push(1);
        s.push(2);
        printStack(s);
        sortStack(s,s.size());
        System.out.println();
        printStack(s);
    }


    public static void sortStack(Stack<Integer> s, int n) {
        if(n <= 1) return;

        int el = s.pop();

        sortStack(s,n-1);

        insertIntoSortedStack(s,el);
    }



    public static void insertIntoSortedStack(Stack<Integer> s, int el) {
        if(s.size() == 0 || s.peek() <= el) {
            s.push(el);
            return;
        }
        int val = s.pop();

        insertIntoSortedStack(s,el);

        s.push(val);

    }


    public static void printStack(Stack<Integer> s) {
        if(s.isEmpty()) return;

        int val = s.pop();
        System.out.print(val + " ");
        printStack(s);
        s.push(val);
    }
}
