package random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 13/02/21
 * @project JavaProgramming
 */
public class ConvertNegatives {
    public int convert(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] > 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        int passes = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                for (int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] >= 0){
                        continue;
                    }
                    queue.offer(new int[]{x,y});
                    matrix[x][y] *= -1;

                }
            }
            passes++;
        }
        return passes - 1;
    }

    public static void main(String[] args) {
        ConvertNegatives convertNegatives = new ConvertNegatives();
        int[][] mat =
                {
                        { -1, -9, 0, -1, 0 },
                        { -8, -3, -2, 9, -7 },
                        { 2, 0, 0, -6, 0 },
                        { 0, -7, -3, 5, -4 }
                };

        System.out.println(convertNegatives.convert(mat));

    }
}
