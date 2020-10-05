package ArraysLearn.basic;

import ArraysLearn.ArrayHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeadersInArray {
    public static void main(String[] args) {
        int a[] = {5, 3, 20, 15, 8, 25};

        Integer[] leaders = findLeaders(a);

        int asnwer[] = Arrays.stream(leaders).mapToInt(Integer::intValue).toArray();

        ArrayHelper.printArray(asnwer);

    }


    private static Integer[] findLeaders(int a[]) {
        if(a.length < 1) {
            throw new AssertionError("Array is empty");
        }

        Stack<Integer> integerStack = new Stack<>();

        int current_max = a[a.length -1];
        integerStack.push(current_max);
        for(int i=a.length-1;i>=0;i--) {
            if(a[i] > current_max) {
                integerStack.push(a[i]);
                current_max = a[i];
            }
        }

        List<Integer> answer  = new ArrayList<Integer>();

        while(integerStack.size() > 0) {
            answer.add(integerStack.pop());
        }

        return answer.toArray(new Integer[answer.size()]);
    }
}
