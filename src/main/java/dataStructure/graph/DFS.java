package dataStructure.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author shivanidwivedi on 23/07/20
 * @project JavaProgramming
 *
 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
 */
public class DFS {

    private int V;
    private LinkedList<Integer> adj[];

    DFS(int v){
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u, int v){
        adj[u].add(v);
    }

    private void dfsTraverse(int v){
        boolean[] visited = new boolean[V];

        //it even works for disconnected graph
        for (int i=0; i<V; ++i){
            if (visited[i] == false)
                dfsUtil(i, visited);
        }
    }

    private void dfsUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+ " ");
        Iterator<Integer> itr = adj[v].iterator();
        while (itr.hasNext()){
            int n = itr.next();
            if(!visited[n]){
                dfsUtil(n,visited);
            }
        }
    }

    public static void main(String s[]){
        DFS b = new DFS(4);
        b.addEdge(0,1);
        b.addEdge(0,2);
        b.addEdge(1,2);
        b.addEdge(2,0);
        b.addEdge(2,3);
        b.addEdge(3,3);
        System.out.print("" + "");
        b.dfsTraverse(2);
    }
}
