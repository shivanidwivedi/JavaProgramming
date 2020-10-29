package dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shivanidwivedi on 29/10/20
 * @project JavaProgramming
 */
public class TopologicalSortMethod {
    private int V;
    List<Integer> adj[];

    TopologicalSortMethod(int V){
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest){
        adj[src].add(dest);
    }

    private List<Integer> sort(){
        boolean[] visited = new boolean[V];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = calculateIndegree();
        for (int i = 0;i < V; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int current = queue.poll();
            list.add(current);
            visited[current] = true;
            for(int adj : adj[current]){
                indegree[adj]--;
                if (indegree[adj] == 0 && !visited[adj]){
                    queue.add(adj);
                }
            }
        }
        return list;
    }

    private int[] calculateIndegree(){
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++){
            for(int adj : adj[i]){
                indegree[adj]++;
            }
        }
        return indegree;
    }
    public static void main(String[] args) {
        TopologicalSortMethod g = new TopologicalSortMethod(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(g.sort());
    }
}
