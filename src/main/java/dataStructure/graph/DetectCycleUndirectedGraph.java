package dataStructure.graph;

import java.util.*;

/**
 * @author shivanidwivedi on 28/10/20
 * @project JavaProgramming
 *
 * Time Complexity: O(V+E).
 * Space Complexity: O(V).
 */
public class DetectCycleUndirectedGraph {
    private int V;
    private HashMap<Integer, List<Integer>> adj;

    DetectCycleUndirectedGraph(int v){
        V = v;
        adj = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < V; i++){
            adj.put(i, new LinkedList<>());
        }
    }

    void addEdge(int src, int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    private boolean isCycleUtil(int vertex, HashSet<Integer> visited, int parent){
        visited.add(vertex);
        Integer currentVertex;
        Iterator<Integer> iterator = adj.get(vertex).iterator();
        while (iterator.hasNext()){
            currentVertex = iterator.next();
            if(!visited.contains(currentVertex)){
                if(isCycleUtil(currentVertex , visited, vertex)){
                    return true;
                }
            }else if(currentVertex != parent){
                return true;
            }
        }
        return false;
    }

    private boolean isCycle() {
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < V; i++){
            if (!visited.contains(i)){
                if (isCycleUtil(i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        DetectCycleUndirectedGraph graph = new DetectCycleUndirectedGraph(5);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        System.out.println(graph.isCycle());

        DetectCycleUndirectedGraph graph1 = new DetectCycleUndirectedGraph(3);
        graph1.addEdge(0,1);
        graph1.addEdge(1,2);
        System.out.println(graph1.isCycle());
    }
}
