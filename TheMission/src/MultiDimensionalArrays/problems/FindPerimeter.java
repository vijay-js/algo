package MultiDimensionalArrays.problems;

public class FindPerimeter {
    public static void main(String[] args) {
        int a[][] = {
                {0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}

        };
        System.out.print(islandPerimeter(a));
    }

    public static int islandPerimeter(int[][] a) {
        if(a.length ==0) return 0;

        int answer = 0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                if(a[i][j] == 0) {
                    //water -> no permieyer
                }
                else {
                    //land case

                    //check left
                    if(j-1 >= 0 || j==0) {
                        //count if water or left boundary
                        if( j==0 || a[i][j-1] == 0 ) {
                            answer+=1;
                        }
                    }

                    //check right
                    if(j+1 < a[i].length || j==a[i].length -1) {
                        if(j==a[i].length -1 || a[i][j+1] ==0) {
                            answer+=1;
                        }
                    }


                    //check top

                    if(i-1 >=0 || i==0) {
                        if(i== 0 || a[i-1][j] ==0) {
                            answer+=1;
                        }
                    }


                    //check bottom cell

                    if(i+1 < a.length  || i==a.length-1) {
                        if(i==a.length-1 || a[i+1][j] ==0) {
                            answer+=1;
                        }
                    }

                }

            }
        }
        return answer;
    }
}
