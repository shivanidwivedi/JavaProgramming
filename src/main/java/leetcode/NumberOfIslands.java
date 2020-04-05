package leetcode;

/**
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * @author shivanidwivedi on 04/04/20
 * @project JavaProgramming
 */
public class NumberOfIslands {
    static void dfs(char[][] grid, int row, int col) {
        int rowlength = grid.length;
        int collength = grid[0].length;

        if (row < 0 || col < 0 || row >= rowlength ||
                col >= collength || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowlength = grid.length;
        int collength = grid[0].length;
        int num_islands = 0;
        for (int row = 0; row < rowlength; ++row) {
            for (int col = 0; col < collength; ++col) {
                if (grid[row][col] == '1') {
                    ++num_islands;
                    dfs(grid, row, col);
                }
            }
        }

        return num_islands;
    }
}
