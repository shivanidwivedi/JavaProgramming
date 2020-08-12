package dataStructure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author shivanidwivedi on 12/08/20
 * @project JavaProgramming
 * Topological Sort, TC : O(V+E), SC : O(V)
 */
public class TopologicalSort {
    private int V;
    ArrayList<ArrayList<Integer>> adj;

    TopologicalSort(int v){
        V = v;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    private void addEdge(int v, int w){
        adj.get(v).add(w);
    }

    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++){
            if(visited[i] == false) {
                topologicalUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public void topologicalUtil(int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;
        Integer i;

        Iterator<Integer> iterator = adj.get(v).iterator();
        while (iterator.hasNext()){
            i = iterator.next();
            if(!visited[i])
            topologicalUtil(i, visited, stack);
        }
        stack.push(new Integer(v));
    }

    public static void main(String s[]){
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(
                "Following is a Topological " +
                        "sort of the given graph");
        g.topologicalSort();
    }
}





