package MultiDimensionalArrays;

public class SpiralOrderOfAMatrix {
    public static void main(String[] args) {
        int a[][] = {
                {2,4,6,8},
                {5,9,12,16},
                {2,11,5,9},
                {3,2,1,8}
        };
        helper.printArray(a);

        spiralPrint(a,a.length,a[0].length);
    }

    private static void spiralPrint(int a[][],int m,int n) {
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        int dir = 0;
        while(top<=bottom && left<=right) {
            if(dir==0) {
                for(int i=left;i<=right;i++) {
                    System.out.print(a[top][i] + " ");
                }
                top++;
                dir = 1;
            }
            else if(dir ==1) {
                for(int i=top;i<=bottom;i++) {
                    System.out.print(a[i][right] + " ");
                }
                right--;
                dir = 2;
            }
            else if(dir ==2) {
                for(int i=right;i>=left;i--) {
                    System.out.print(a[bottom][i]+ " ");
                }
                bottom--;
                dir = 3;
            }
            else if(dir ==3) {
                for(int i=bottom;i>=top;i--) {
                    System.out.print(a[i][left]+ " ");
                }
                left++;
                dir = 0;
            }
            //dir = (dir + 1) % 4;
        }
    }
}
