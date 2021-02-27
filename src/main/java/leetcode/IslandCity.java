package leetcode;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 29/12/20
 * @project JavaProgramming
 */
public class IslandCity {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslandCities(int[][] grid) {
        // Write your code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == false && grid[i][j] != 0) {
                    count += dfs(visit, grid, i, j);
                }
            }
        }
        return count;
    }

    private int dfs(boolean[][] visit, int[][] grid, int row, int col) {
        visit[row][col] = true;
        int count = 0;
        if (grid[row][col] == 2) {
            count++;
        }
        for (int i = 0; i < 4; i++) {
            int x = row + dir[i][0];
            int y = col + dir[i][1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||
                    grid[x][y] == 0 || visit[x][y] == true) {
                continue;
            }
            count += dfs(visit, grid, x, y);
        }
        if (count != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        IslandCity islandCity = new IslandCity();
       /* Assert.assertEquals(0, islandCity.numIslandCities(new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        }));*/
        Assert.assertEquals(2, islandCity.numIslandCities(new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 2, 1, 2},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2}
        }));
    }
}
