package leetcode;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 09/11/20
 * @project JavaProgramming
 */
public class WallsAndGates {
    static int[][] direction = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        if(n == 0 || m == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] coords = queue.poll();
                for (int[] dir : direction){
                    int x = coords[0] + dir[0];
                    int y = coords[1] + dir[1];
                    if(x >= 0 && y >= 0 && x < n && y < n && rooms[x][y] != -1 && !visited[x][y]){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                        rooms[x][y] = level;
                    }
                }
            }
        }
    }
}
