package leetcode.thirty_days_challenge;

/**
 * @author shivanidwivedi on 18/04/20
 * @project JavaProgramming
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * TC: O(mn) SC: O(1) -- Dynamic programming
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        //update first row
        for (int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }
        //update first column
        for (int j = 1; j < grid.length; j++){
            grid[j][0] += grid[j-1][0];
        }
        //update grid with minimum sum
        for (int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
