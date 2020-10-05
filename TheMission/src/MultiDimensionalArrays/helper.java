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
}
