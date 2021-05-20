package RecursionLearn.backtracking;

import java.util.*;

public class BlockedMaze {
    public static void main(String[] args) {
        int mat[][] = new int[4][4];
        Set<Pair> blockedSet = new HashSet<>();

        Collections.addAll(blockedSet,new Pair(0,1),new Pair(2,1),new Pair(3,1),new Pair(3,2));
        mat[0][1] = 1;
        mat[2][1] = 1;
        mat[3][1] = 1;
        mat[3][2] = 1;

        List<List<Pair>> result = new ArrayList<>();
        List<Pair> temp = new ArrayList<>();

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        findAllPaths(mat,visited,0,0,blockedSet,result,temp);
        System.out.println();

    }

    private static void findAllPaths(int[][] mat,boolean[][] visited,int row,int col, Set<Pair> blockedSet, List<List<Pair>> result,List<Pair> temp) {

        if(row == mat.length-1 && col == mat[0].length -1) {
            result.add(new ArrayList<>(temp));
            return;
        }


        if(isValid(mat,row,col,blockedSet,visited)){
            Pair p = new Pair(row,col);
            temp.add(p);
            visited[row][col] = true;
            //top
            findAllPaths(mat,visited,row-1,col,blockedSet,result,temp);
            //bottom
            findAllPaths(mat,visited,row+1,col,blockedSet,result,temp);
            //right
            findAllPaths(mat,visited,row,col+1,blockedSet,result,temp);
            //left
            findAllPaths(mat,visited,row,col-1,blockedSet,result,temp);

            visited[row][col] = false;
            for(int i=0;i<temp.size();i++) {
                if(temp.get(i) == p) {
                    temp.remove(i);
                }
            }

        }


    }

    private static boolean isValid(int[][] mat,int row, int col,Set<Pair> blockedSet,boolean[][] visited) {
        Pair coord = new Pair(row,col);
        if(row <0 || row >= mat.length || col <0 || col >= mat[0].length || visited[row][col] == true || mat[row][col] ==1) {
            return false;
        }
        return true;

    }



}

class Pair {
    int x;
    int y;

    Pair(int x,int y) {
        this.x = x;
        this.y =y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
