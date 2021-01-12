package Misc;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int nums1 []= {3,7,8,0,0,0};
        int nums2 [] = {2,5,6};

        int m = 3;
        int n = nums2.length;

        merge1(nums1,nums2,m,n);
    }

    public static void merge1(int nums1[],int nums2[],int m,int n) {
        m--;
        n--;
        while(m>=0 && n>=0) {
            if(nums1[m] > nums2[n]) {
                nums1[m+n+1] = nums1[m--];
            }
            else {
                nums1[m+n+1] = nums2[n--];
            }
        }

        while(n>=0) {
            nums1[m+n+1] = nums2[n--];
        }
        System.out.println();
    }

    public static int[] merge(int nums1[], int nums2[], int m , int n) {
        if(n == 0) return nums1;

        int k = nums1.length-1;

        while(m-1 >=0 && n-1>=0) {
            if(nums1[m-1] > nums2[n-1]) {
                nums1[k] = nums1[m-1];
                m--;
            }
            else {
                nums1[k] = nums2[n-1];
                n--;
            }
            k--;
        }

        if(n-1>=0) {
            while(k<=0 && n-1>=0) {
                nums1[k] = nums2[n-1];
                n--;
            }
        }
        return nums1;
    }

}
