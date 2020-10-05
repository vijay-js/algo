package ArraysLearn.InterviewPrep;


//Print Array in ZigZag Pattern
//a<b>c<d>e

import ArraysLearn.ArrayHelper;

import static ArraysLearn.basic.ReverseAnArray.swap;


public class ZigZagPattern {


    public static void main(String[] args) {

        int arr[] = new int[] {4,3,7,8,6,2,1};

        ArrayHelper.printArray(arr);
//        makeZigZag(arr);
        makeItZigAndZag(arr);
        ArrayHelper.printArray(arr);

    }

    private static void makeItZigAndZag(int []a) {
        Direction d = Direction.LESSER;

        for(int i=0;i<a.length-1;i++) {
            if(d == Direction.LESSER && a[i] > a[i+1]) {
                swap(a,i,i+1);
            }
            else if (d== Direction.GREATER && a[i] < a[i+1]) {
                swap(a,i,i+1);
            }
            d = d.toggle();
        }
    }

    public static void makeZigZag(int a[]) {
        boolean flag = true;
        for(int i=0;i<a.length -1;i++) {
            if(flag) {
                if(a[i] > a[i+1]) {
                    swap(a, i, i + 1);
                }
            }
            else {
                if(a[i] < a[i+1]) {
                    swap(a,i,i+1);
                }
            }
            flag = !flag;
        }
    }



    public enum  Direction {
        GREATER,
        LESSER;

        public Direction toggle() {
            if( this == Direction.GREATER) {
                return Direction.LESSER;
            }
            return Direction.GREATER;
        }
    }



}


