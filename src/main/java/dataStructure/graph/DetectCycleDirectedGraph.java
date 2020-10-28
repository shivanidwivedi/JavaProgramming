package dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shivanidwivedi on 28/10/20
 * @project JavaProgramming
 * Time Complexity : O(V+E)
 */
public class DetectCycleDirectedGraph {
    static class Graph{
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V){
            this.V = V;
            this.adj = new LinkedList[V];
            for (int i = 0; i < V; i++){
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int u, int w){
            adj[u].add(w);
        }

        private boolean isCycle(){
            int[] indegree = calculateIndegree();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < V; i++){
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
            List<Integer> orderedList = new LinkedList<>();
            int visitedCount = 0;
            while (!queue.isEmpty()){
                int currentVertex = queue.poll();
                orderedList.add(currentVertex);
                for(int adjVertex : adj[currentVertex]){
                    indegree[adjVertex]--;
                    if (indegree[adjVertex] == 0){
                        queue.add(adjVertex);
                    }
                }
                visitedCount++;
            }
            if(visitedCount != V){
                return true;
            }
            return false;
        }

        private int[] calculateIndegree(){
            int[] indegree = new int[this.V];
            for(int i = 0; i < V; i++){
                for(int j : adj[i]){
                    indegree[j]++;
                }
            }
            return indegree;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(0,3);
        graph.addEdge(2,4);
        graph.addEdge(4,2);
        System.out.println(graph.isCycle());
    }

}
