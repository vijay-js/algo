package ArraysLearn.InterviewPrep.subArray;

//Given an array of elements and integer k . Find the count of subarray which have elements greater than k

//Find all contingous

class CountSubArrayMaxElementGreaterThanK {
    public static void main(String[] args) {
        int a[] = {3,4,1,2,5};
        int k =3;

        findSubArrayContigousElementsLessThanK(a,k);

    }

    private static void findSubArrayContigousElementsLessThanK(int a[],int k) {
        int start = 0 ,end =0;

//        while(end <a.length) {
//            if(a[end] > k) {
//                //Some subArrays we have
//                if(start != end) {
//                    System.out.println("Numbers from "+ start +"to "+(end-1) +" with size"+ (end -start));
//                }
//                start = end +1;
//                end++;
//                continue;
//            }
//            if(a[end] <= k) {
//                end++;
//            }
//        }


        for(int i=0;i<a.length;i++) {
            if(a[i] > k) continue;
            int count =0;
            for(;a[i]<=k;i++) {
                count++;
            }
            System.out.println(count);

        }
    }
}


