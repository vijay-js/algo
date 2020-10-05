package BinarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int a[] = {1,2};
        int b[] = {2,3,4};

      //  (1 , 2 , 3, 4, 5   N /2 , N/2 -1 )

        //1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8 // 11

        System.out.println(findMedian(a,b));
    }



    private static int findMedian(int a[], int b[]) {
        int len = a.length + b.length;
        int c [] = new int[len];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i< a.length && j<b.length) {
            if(a[i] < b[j]) {
                c[k] = a[i];
                i++;
            }
            else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while(i<a.length) {
            c[k] = a[i];
            k++;
            i++;
        }

        while(j<b.length) {
            c[k] = b[j];
            j++;
            k++;
        }
        return len%2 == 0? (c[len/2] + c[len/2 -1] )/2 : c[len/2];
    }


    private static double findMedianBetter(int a[], int b[]) {
        if(a.length > b.length) {
            return findMedianBetter(b,a);
        }

        //b has greater length;
        int x = a.length;
        int y = b.length;

        int low = 0;
        int high = x;

        while(low <=high) {
            int partitionX = low + (high - low) /2;

            //Partition X + Partition Y = X + Y+ 1/2 // The addition 1 is to play with odd and even sized lengths
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX -1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE: a[partitionX];


            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY -1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE: b[partitionY];


            if(maxLeftX <= minRightY && maxLeftY <= minRightX)  {
                //Correct partition

                if((x + y) %2 ==0)  {
                     return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }
                else {
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }
            else if(maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX -1;
            }
            else {  //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();

    }


}
