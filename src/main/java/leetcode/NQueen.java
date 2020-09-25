package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 24/09/20
 * @project JavaProgramming
 */
public class NQueen {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, n, new ArrayList<Integer>(), result);

        return result;
    }

    private static void backtrack(int row, int n, List<Integer> colPlacements,
                           List<List<String>> result){
        if(row == n){
            result.add(new ArrayList(colPlacements));
        }else{
            for(int col = 0; col < n; col++){
                colPlacements.add(col);
                if(isValid(colPlacements)){
                    backtrack(row+1, n, colPlacements, result);
                }
                colPlacements.remove(colPlacements.size()-1);
            }
        }
    }

    private static boolean isValid(List<Integer> colPlacements){
        int row = colPlacements.size()-1;
        for(int i = 0; i < row; i++){
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(row));
            if(diff == 0 || diff == row-i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] s){
        System.out.println(solveNQueens(4));
    }
}
