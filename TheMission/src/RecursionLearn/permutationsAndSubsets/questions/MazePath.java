package RecursionLearn.permutationsAndSubsets.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazePath {
    public static void main(String[] args) {

        List<List<Pair>> ans = new ArrayList<>();

        List<Pair> result = new ArrayList<>();
        Pair origin = new Pair(0,0);
        result.add(origin);

        int mat[][] = new int[3][3];

        findPath(mat,0,0,result,ans);

        for(List<Pair> pairs : ans) {
            for(Pair p: pairs) {
                System.out.print("("+p.x+","+p.y+")"+"->");
            }
            System.out.println();
        }
    }

    public static void findPath(int [][] mat, int row, int col, List<Pair> path,List<List<Pair>> ans) {

            if(row > mat.length-1) {
                return;
            }
            if(col > mat[0].length-1) {
                return;
            }
            if(row == mat.length-1&& col == mat[0].length-1) {
                ans.add(path);
                return;
            }
            List<Pair> path1 = new ArrayList<>(path);
            path1.add(new Pair(row+1,col));
            findPath(mat,row+1,col,path1,ans);

            List<Pair> path2 = new ArrayList<>(path);
            path2.add(new Pair(row,col+1));
            findPath(mat,row,col+1,path2,ans);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
