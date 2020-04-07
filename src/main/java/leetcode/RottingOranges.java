package leetcode;

/**
 * @author shivanidwivedi on 06/04/20
 * @project JavaProgramming
 * rotten oranges --- DFS
 *
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        /**
         * loop and start dfs for all rotten oranges
         */
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if (grid[row][col] == 2){
                    dfs(grid,row,col,2); //starting from 2 to easily recognize the visited oranges
                }
            }
        }
        int minutes = 0;
        /**
         * find max in the grid and check the grid if there are any fresh oranges left, if yes return -1.
         */
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1){    //fresh oranges left in the grid
                    return -1;
                }
                minutes = Math.max(minutes,grid[row][col]);
            }
        }
        return (minutes == 0) ? 0: minutes - 2; //-2 as the value started from 2
    }
    private static void dfs(int[][] grid, int row, int col, int val) {

        /**
         * (grid[row][col] >= 2 && grid[row][col] < val) -> whoooo, this is how I mark em visited baby.
         * otherwise I will end up visiting the same node again like a fool.
         */
        if (row < 0 || col < 0 || row >= grid.length ||
                col >= grid[row].length || grid[row][col] == 0 || (grid[row][col] >= 2 && grid[row][col] < val)) {
            return;
        }
        /**
         * grid[row][col] > 2 : val is something we want to replace to current cell.
         * this also carry time, may I remind you. So if the cell somehow managed to skip the above condition,
         * it has to stop here.
         */
        if(grid[row][col] == 1 || grid[row][col] > 2 ){
            grid[row][col] = val;
        }

        dfs(grid, row - 1, col, val + 1);
        dfs(grid, row , col + 1, val + 1);
        dfs(grid, row + 1, col, val + 1);
        dfs(grid, row, col - 1, val + 1);
    }


}
