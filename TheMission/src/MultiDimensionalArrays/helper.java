package MultiDimensionalArrays;

public class helper {

    private helper() {

    }

    public static void initInSequence(int a[][]){
        int m = a.length;
        int count = 1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<a[i].length;j++) {
                a[i][j] = count ++;
            }
        }

    }


    public static void printArray(int a[][]) {
        int m = a.length;
        int n = a[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void printArrayColumnWise(int a[][]) {
        for(int j=0;j<a[0].length;j++) {
            for(int i=0;i<a.length;i++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void log(Object o) {
        System.out.println(o);
    }

    public static void printRowWise(int a[][], int rowNumber) {
        int[] rowArray = a[rowNumber];
        log("Printing Row " + rowNumber);
        for(int i=0;i<rowArray.length;i++) {
            System.out.print(rowArray[i] + " ");
        }
    }

    public static void printColumnWise(int a[][], int columnNumber) {
        int columnArray[] = new int[a.length];

        for(int i=0;i<a.length;i++) {
            columnArray[i] = a[i][columnNumber];
        }
        System.out.println();
        log("Printing Column " + columnNumber);
        for(int i=0;i<columnArray.length;i++) {
            System.out.print(columnArray[i] + " ");
        }
    }

    public static void printColumnW(int a[][], int colNumber) {
        int ans[] = new int[a.length];

        for(int i=0;i<a.length;i++) {
            System.out.print(a[i][colNumber]);
        }
    }

    public static void printCWiseWithDiffColumns(int [][] arr) {
        int c = getMaxNumberOfColumns(arr);
        for(int j=0;j<c;j++) {
            for(int i=0;i<arr.length;i++) {
                try {
                    System.out.print(arr[i][j] + " ");
                }
                catch (Exception e) {

                }
                System.out.println();
            }
        }
    }

    private static int getMaxNumberOfColumns(int [][] a) {
        int answer = 0;
        for(int i=0;i<a.length;i++) {
             answer = Math.max(answer,a[i].length);
        }
        return answer;
    }
}
