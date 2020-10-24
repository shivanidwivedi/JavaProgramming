package dataStructure.graph;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 22/10/20
 * @project JavaProgramming
 *
 * A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned
 * into a number of disjoint (non-overlapping) subsets. A union-find algorithm is an algorithm that performs
 * two useful operations on such a data structure:
 *
 * Find: Determine which subset a particular element is in.
 * This can be used for determining if two elements are in the same subset.
 * Union: Join two subsets into a single subset.
 *
 * In this post, we will discuss the application of Disjoint Set Data Structure.
 * The application is to check whether a given graph contains a cycle or not.
 *
 * Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not.
 * Note that we have discussed an algorithm to detect cycle. This is another method based on Union-Find.
 * This method assumes that the graph doesn’t contain any self-loops.
 * We can keep track of the subsets in a 1D array, let’s call it parent[].
 *
 * Let us consider the following graph:
 * cycle-in-graph
 * For each edge, make subsets using both the vertices of the edge.
 * If both the vertices are in the same subset, a cycle is found.
 *
 * Initially, all slots of parent array are initialized to -1 (means there is only one item in every subset).
 *
 * 0   1   2
 * -1 -1  -1
 * Now process all edges one by one.
 *
 * Edge 0-1: Find the subsets in which vertices 0 and 1 are. Since they are in different subsets, we take the union of them. For taking the union, either make node 0 as parent of node 1 or vice-versa.
 *
 * 0   1   2    <----- 1 is made parent of 0 (1 is now representative of subset {0, 1})
 * 1  -1  -1
 * Edge 1-2: 1 is in subset 1 and 2 is in subset 2. So, take union.
 *
 * 0   1   2    <----- 2 is made parent of 1 (2 is now representative of subset {0, 1, 2})
 * 1   2  -1
 * Edge 0-2: 0 is in subset 2 and 2 is also in subset 2. Hence, including this edge forms a cycle.
 *
 * How subset of 0 is same as 2?
 * 0->1->2 // 1 is parent of 0 and 2 is parent of 1
 */
public class UnionFind {
    int V, E;
    Edge edge[];

    class Edge{
        int source, destination;
    };

    UnionFind(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++){
            edge[i] = new Edge();
        }
    }
    // A utility function to find the subset of an element i
    private int find(int parent[], int i){
        if (parent[i] == -1){
            return i;
        }
        return find(parent, parent[i]);
    }
    // A utility function to do union of two subsets
    private void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    private boolean isCycle(UnionFind graph){
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < graph.E; i++){
            int x = graph.find(parent, edge[i].source);
            int y = graph.find(parent, edge[i].destination);
            if (x == y){
                return true;
            }
            graph.union(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        UnionFind graph = new UnionFind(V, E);

        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;

        // add edge 1-2
        graph.edge[1].source = 1;
        graph.edge[1].destination = 2;

        // add edge 0-2
        graph.edge[2].source = 0;
        graph.edge[2].destination = 2;

        if (graph.isCycle(graph))
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
