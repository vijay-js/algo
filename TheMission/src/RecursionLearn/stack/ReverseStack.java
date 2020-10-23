package RecursionLearn.stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(8);
        s.push(10);

        StackPrinter.print(s);
        reverseStack(s,s.size());
        StackPrinter.print(s);
    }


    public static void reverseStack(Stack<Integer> s, int n) {
        if(s.size() <= 1)  {
            return;
        }
        int el = s.pop();
        reverseStack(s,n-1);
        insertAtEndBottomOfStack(s,el);
    }

    public static void insertAtEndBottomOfStack(Stack<Integer>s , int el) {
        if(s.size() == 0) {
            s.push(el);
            return;
        }
        int val = s.pop();
        insertAtEndBottomOfStack(s,el);
        s.push(val);
    }
}
