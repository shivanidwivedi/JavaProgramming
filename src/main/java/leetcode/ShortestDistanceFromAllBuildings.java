package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 11/02/21
 * @project JavaProgramming
 */
public class ShortestDistanceFromAllBuildings {
    int[][] visited;
    int[][] distance;
    int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new int[m][n];
        distance = new int[m][n];
        int totalBuildings = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j, totalBuildings);
                    totalBuildings++;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visited[i][j] == totalBuildings){
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void bfs(int[][] grid, int row, int col, int buildings){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        int steps = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.remove();
                row = curr[0];
                col = curr[1];
                distance[row][col] += steps;
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0
                            && visited[x][y] == buildings){
                        q.offer(new int[]{x,y});
                        visited[x][y]++;
                    }
                }
            }
            steps++;
        }
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings obj = new ShortestDistanceFromAllBuildings();
        System.out.println(obj.shortestDistance(new int[][]{
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        }));
    }
}
