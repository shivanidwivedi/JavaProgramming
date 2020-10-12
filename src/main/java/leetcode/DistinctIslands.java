package leetcode;

import java.util.HashSet;

/**
 * @author shivanidwivedi on 12/10/20
 * @project JavaProgramming
 */
public class DistinctIslands {
    public static int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        //set to store unique islands
        HashSet<String> unique = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder(); //String builder to store the direction of current island
                    dfs(grid, visited, i, j, sb, ".");
                    unique.add(sb.toString());
                }
            }
        }
        return unique.size();
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col,
                     StringBuilder sb, String direction){
        if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length
                && !visited[row][col] && grid[row][col] == 1){
            sb.append(direction);
            visited[row][col] = true;
            dfs(grid, visited, row+1, col, sb, "D");
            dfs(grid, visited, row-1, col, sb, "U");
            dfs(grid, visited, row, col+1, sb, "R");
            dfs(grid, visited, row, col-1, sb, "L");
            sb.append("/");
        }
    }

    public static void main(String[] args) {
        System.out.println(numDistinctIslands(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        }));
        System.out.println(numDistinctIslands(new int[][]{
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        }));
    }
}
