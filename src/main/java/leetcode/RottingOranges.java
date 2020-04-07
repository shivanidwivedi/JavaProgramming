package leetcode;

/**
 * @author shivanidwivedi on 06/04/20
 * @project JavaProgramming
 * rotten oranges
 */
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if (grid[row][col] == 2){
                    dfs(grid,row,col,2);
                }
            }
        }
        int minutes = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1){
                    return -1;
                }
                minutes = Math.max(minutes,grid[row][col]);
            }
        }
        return (minutes == 0) ? 0: minutes - 2;
    }
    private static void dfs(int[][] grid, int row, int col, int val) {

        if (row < 0 || col < 0 || row >= grid.length ||
                col >= grid[row].length || grid[row][col] == 0 || (grid[row][col] >= 2 && grid[row][col] < val)) {
            return;
        }
        if(grid[row][col] == 1 || grid[row][col] > 2 ){
            grid[row][col] = val;
        }

        //grid[row][col] = '0';
        dfs(grid, row - 1, col, val + 1);
        dfs(grid, row , col + 1, val + 1);
        dfs(grid, row + 1, col, val + 1);
        dfs(grid, row, col - 1, val + 1);
    }


}
