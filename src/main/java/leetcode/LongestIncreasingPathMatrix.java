package leetcode;

/**
 * @author shivanidwivedi on 11/02/21
 * @project JavaProgramming
 */
public class LongestIncreasingPathMatrix {
    int[][] dirs = new int[][]{{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, longestPath = 0;
        int[][] memo = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(memo[i][j] == 0){
                    int longest = dfs(matrix, i, j, memo, Integer.MIN_VALUE);
                    longestPath = Math.max(longest, longestPath);
                }
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo, int previous){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] <= previous){
            return 0;
        }
        if(memo[row][col] != 0){
            return memo[row][col];
        }
        int max = 0;
        int left = dfs(matrix, row, col - 1, memo, matrix[row][col]);
        int right = dfs(matrix, row, col + 1, memo, matrix[row][col]);
        int up = dfs(matrix, row - 1, col, memo, matrix[row][col]);
        int down = dfs(matrix, row + 1, col, memo, matrix[row][col]);

        memo[row][col] = Math.max(Math.max(Math.max(left, right), up), down) + 1;

        return memo[row][col];
    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix obj = new LongestIncreasingPathMatrix();
        System.out.println(obj.longestIncreasingPath(new int[][]{
                {9,9,4},
                {6,6,8},
                {2,1,1}
        }));
    }
}
