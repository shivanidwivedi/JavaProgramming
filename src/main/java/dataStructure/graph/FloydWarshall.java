package dataStructure.graph;

/**
 * @author shivanidwivedi on 05/08/20
 * @project JavaProgramming
 * The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem.
 * The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.
 * Example:
 *
 * Input:
 *        graph[][] = { {0,   5,  INF, 10},
 *                     {INF,  0,  3,  INF},
 *                     {INF, INF, 0,   1},
 *                     {INF, INF, INF, 0} }
 * which represents the following graph
 *              10
 *        (0)------->(3)
 *         |         /|\
 *       5 |          |
 *         |          | 1
 *        \|/         |
 *        (1)------->(2)
 *             3
 * Note that the value of graph[i][j] is 0 if i is equal to j
 * And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.
 *
 * Output:
 * Shortest distance matrix
 *       0      5      8      9
 *     INF      0      3      4
 *     INF    INF      0      1
 *     INF    INF    INF      0
 * TC: O(V^3)
 */
public class FloydWarshall {
    int V = 4;
    final static int INF = 99999;
    public void allPairsShortestPath(int[][] graph){
        int[][] dist = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++){
            for(j = 0; j < V; j++){
                dist[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < V; k++){
            for (i = 0; i < V; i++){
                for (j = 0; j < V; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int dist[][]){
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] s){
        int[][] graph = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.allPairsShortestPath(graph);
    }
}
