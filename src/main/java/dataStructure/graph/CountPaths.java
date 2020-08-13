package dataStructure.graph;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 13/08/20
 * @project JavaProgramming
 */
public class CountPaths {

    private static int totalVertices;

    private static LinkedList<Integer> adj[];

    CountPaths(int v)
    {
        totalVertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Method to add an edge into the graph
    static void addEdge(int v, int w)
    {
        adj[v].add(w);

    }

    public static int countPaths(int source, int destination){
       int count = 0;
        count = countPathUtil(source, destination, count);
        return count;
    }

    public static int countPathUtil(int source, int destination, int count){
        if(source == destination){
            count++;
        }else {
            Iterator<Integer> itr = adj[source].iterator();
            while (itr.hasNext()){
                int i = itr.next();
                count = countPathUtil(i,destination,count);
            }
        }
        return count;
    }

    public static void main(String[] str){
        CountPaths g = new CountPaths(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        System.out.println(countPaths(0,3));
    }

}



