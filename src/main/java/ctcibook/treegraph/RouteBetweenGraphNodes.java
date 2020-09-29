package ctcibook.treegraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 */
public class RouteBetweenGraphNodes {
    static private int V;   // No. of vertices
    static private LinkedList<Integer> adj[]; //Adjacency List

    RouteBetweenGraphNodes(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    static void addEdge(int v, int w){
        adj[v].add(w);
    }

    public static boolean isReachable(int source, int destination){
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[V];
        visited[source] = true;
        queue.offer(source);

        Iterator<Integer> iterator;
        while (!queue.isEmpty()){
            source = queue.poll();
            iterator = adj[source].listIterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if (n == destination){
                    return true;
                }
                if (!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
        return false;
    }

    public static void main(String[] s){
        RouteBetweenGraphNodes graphNodes = new RouteBetweenGraphNodes(4);
        graphNodes.addEdge(0, 1);
        graphNodes.addEdge(0, 2);
        graphNodes.addEdge(1, 2);
        graphNodes.addEdge(2, 0);
        graphNodes.addEdge(2, 3);
        graphNodes.addEdge(3, 3);
        System.out.println(isReachable(3,1));
        System.out.println(isReachable(3,3));
        System.out.println(isReachable(2,1));
    }
}

