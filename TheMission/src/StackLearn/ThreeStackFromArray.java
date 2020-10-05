package StackLearn;

public class ThreeStackFromArray {

    StackNode arr[];
    int topArr[];
    int freePos;


    public ThreeStackFromArray(int size) {
       arr = new StackNode[size];
       topArr = new int[]{-1,-1,-1};
       freePos=0;
    }


    public void push(int x, int stackNumber) {
        //stackNumber is 1,2,3

    }

    public static void main(String[] args) {

    }


    public class StackNode {
        int val;
        int prev;

        StackNode(int val,int prev) {
            this.val = val;
            this.prev = prev;
        }
    }
}
