package random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 27/05/21
 * @project JavaProgramming
 */
public class APractice2 {
    public int minDistance(int[][] input){
        if (input == null || input.length == 0){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        if(input[0][0] == 1)
        queue.offer(new int[]{0,0});
        int m = input.length, n = input[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int dist = 0;
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {0,1}, {1,0}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.remove();
                if(input[current[0]][current[1]] == 9){
                    return dist;
                }
                for(int[] dir : dirs){
                    int x = dir[0] + current[0];
                    int y = dir[1] + current[1];
                    if(x >= 0 && y >= 0 && x < input.length &&
                            y < input[0].length && !visited[x][y] && input[x][y] != 0){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    public static void main(String[] args) {
        APractice2 obj = new APractice2();
        System.out.println(obj.minDistance(new int[][]{{1,0,0}, {1,0,0}, {1,9,1}}));
        System.out.println(obj.minDistance(new int[][]{{1,1,0,1,9}, {1,1,1,1,0}, {1,0,1,1,1}}));
        System.out.println(obj.minDistance(new int[][]{{0,0,0}, {1,0,0}, {1,9,1}}));
    }
}
