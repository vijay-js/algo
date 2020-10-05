package StackLearn;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> s1;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    /** THE BEST WAY IS TO USE Node in linked list with min as extra field in the node **/
    public MinStack() {
        s1 = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if(minStack.isEmpty() ||  x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(!s1.isEmpty()) {
            int x = s1.peek();
            s1.pop();
            if(minStack.peek() == x) {
                minStack.pop();
            }
        }

    }

    public int top() {

        return s1.peek();


    }

    public int getMin() {
            return minStack.peek();


    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}