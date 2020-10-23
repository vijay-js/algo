package RecursionLearn.stack;

import java.util.Stack;

public class InsertInMiddle {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int k = 22;
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(8);
        s.push(10);


        //10 >1 > 8  > 3 > 2
        StackPrinter.print(s);
        int middleElementIndex = s.size()/2 + 1;
//        deleteMiddleElement(s,middleElementIndex, 1);
//        insertIntoMiddle(s,s.size(),k);

        delMiddle(s,s.size(),1);
        StackPrinter.print(s);
    }

    private static void insertIntoMiddle(Stack<Integer> s, int n,int k) {
        if(n<=0) {
            return;
        }


        if(s.size() == n/2 +1) {
            s.push(k);
            return;
        }
        int x = s.pop();

        insertIntoMiddle(s,n,k);
        s.push(x);

    }


    private static void deleteMiddleElement(Stack<Integer> s, int id, int i) {

        if(id == i) {
            s.pop();
            return;
        }
        int x = s.pop();
        deleteMiddleElement(s,id,i+1);
        s.push(x);

    }

    private static void delMiddle(Stack<Integer> s, int size, int i) {
        if(size <=1) {
            return;
        }
        if(i == size/2 + 1) {
            s.pop();
            return;
        }
        int el = s.pop();
        delMiddle(s,size,i+1);
        s.push(el);
    }

}
