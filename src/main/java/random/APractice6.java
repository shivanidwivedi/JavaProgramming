package random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 02/06/21
 * @project JavaProgramming
 */
public class APractice6 {
    int counter = 0;
    public int costEvaluation(int n, int[][] connections) {
        int[] visited = new int[n];
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.length; i++) {

            adjList[connections[i][0]].add(connections[i][1]);
            adjList[connections[i][1]].add(connections[i][0]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                counter = 0;
                dfs(adjList, visited, i);
                sum+=Math.ceil(Math.sqrt(counter));
            }
        }
        return sum;
    }
    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;
        counter++;
        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }

    public static void main(String[] args) {
        APractice6 obj = new APractice6();
        System.out.println(obj.costEvaluation(4, new int[][]{{0,2},{1,2}}));
       // System.out.println(obj.costEvaluation(10, new int[][]{{2,6},{3,5},{0,1},{2,9},{5,6}}));
    }
}
