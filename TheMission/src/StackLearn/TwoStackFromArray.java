package StackLearn;

public class TwoStackFromArray {
    int arr[];
    int top1;
    int top2;

    public TwoStackFromArray(int size) {
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }


    public void push1(int x) {
        if(top1 < top2 -1) {
            top1++;
            arr[top1] = x;
        }
        else {
            throw new StackOverflowError("Overflow brotha");
        }
    }

    public void push2(int x) {
        if(top2 > top1 + 1) {
            top2--;
            arr[top2] = x;
        }
        else {
            throw new StackOverflowError("Overflow brotha");
        }
    }

    public int pop1() {
        if(top1 == -1) {
            throw new AssertionError("Cant pop from empty stack");
        }
        else {
            int ret = arr[top1];
            top1--;
            return ret;
        }
    }

    public int pop2() {
        if(top2 == arr.length) {
            throw new AssertionError("Cant pop from empty stack");
        }
        else {
            int ret = arr[top2];
            top2++;
            return ret;
        }
    }


    public void PrintStack() {
        for(int i=0;i<=top1;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(" -------  ");

        for(int j= arr.length-1;j>=top2;j--) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        TwoStackFromArray stack = new TwoStackFromArray(5);
        stack.push1(1);
        stack.push1(2);
        stack.push1(3);
        stack.push2(8);
        stack.push2(6);
        stack.PrintStack();
    }
}
