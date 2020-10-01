package leetcode;

/**
 * @author shivanidwivedi on 26/09/20
 * @project JavaProgramming
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        obstacleGrid[0][0] = 1;

        for(int i = 1; i < colLen; i++){
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for(int i = 1; i < rowLen; i++){
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for(int i = 1; i < rowLen; i++){
            for(int j = 1; j < colLen; j++){
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }else{
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[rowLen-1][colLen-1];
    }

    public static void main(String[] s){
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
    }
}
