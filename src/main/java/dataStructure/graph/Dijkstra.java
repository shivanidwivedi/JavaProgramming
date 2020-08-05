package dataStructure.graph;

/**
 * @author shivanidwivedi on 05/08/20
 * @project JavaProgramming
 * Dijkstra algo for undirected graph, same can be done for directed graph
 * Time Complexity of the implementation is O(V^2). If the input graph is represented using adjacency list, it can be reduced to O(E log V) with the help of binary heap.
 */
public class Dijkstra {
    static final int V = 9;
    public void singleSourceShortestPath(int[][] graph, int src){
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V-1; count++){
            int u = minDistance(dist,sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++){
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        printSolution(dist);
    }

    public int minDistance(int dist[], boolean sptSet[]){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int v = 0; v < V; v++){
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public void printSolution(int[] dist){
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void main(String[] s){
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.singleSourceShortestPath(graph,0);
    }
}
