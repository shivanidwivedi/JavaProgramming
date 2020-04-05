package dataStructure.graph;


import java.util.Iterator;

/**
 * @author shivanidwivedi on 04/04/20
 * @project JavaProgramming
 *
 * For graph related functionality @see {@link Graph}
 */
public class DepthFirstSearch {
    private int vertex;
    private Graph graph;
    DepthFirstSearch(int root, Graph graph){
        this.vertex = root;
        this.graph = graph;
    }
    public void dfsRecursive(int v){
        boolean visited[] = new boolean[graph.numberOfVertices];
        DFSUtil(v,visited);
    }
    public void DFSUtil(int v, boolean visited[]){
        visited[v] = true;
        System.out.println(v+" ");
        Iterator<Integer> i = graph.getAdjacentNodes(v).iterator();
        while (i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }
    public static void main(String args[])
    {
        /**
         * Build graph
         */
        Graph graph = new Graph(4, Graph.GraphType.DIRECTED);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        //run DFS on the above graph
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(2, graph);


        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        depthFirstSearch.dfsRecursive(2);
    }
}
