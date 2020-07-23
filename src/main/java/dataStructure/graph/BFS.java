package dataStructure.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author shivanidwivedi on 22/07/20
 * @project JavaProgramming
 *
 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
 */
public class BFS {
    private int V;
    private LinkedList<Integer> adj[];

    BFS(int v){
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u, int w){
        adj[u].add(w);
    }

    private void bfsTraverse(int source){
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()){
            source = queue.poll();
            System.out.print(source +" ");
            Iterator<Integer> itr = adj[source].iterator();
            while (itr.hasNext()){
                int n = itr.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String s[]){
        BFS b = new BFS(4);
        b.addEdge(0,1);
        b.addEdge(0,2);
        b.addEdge(1,2);
        b.addEdge(2,0);
        b.addEdge(2,3);
        b.addEdge(3,3);
        System.out.print("" + "");
        b.bfsTraverse(2);
    }
}
