package dataStructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 28/10/20
 * @project JavaProgramming
 */
public class GenericGraph<T> {
    private HashMap<T, List<T>> map = new HashMap<>();

    /**
     * adds a vertex to the graph
     * @param vertex
     */
    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<T>());
    }

    /**
     * adds an edge to the graph
     * @param source
     * @param dest
     * @param bidirectional
     */
    public void addEdge(T source, T dest, boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(dest)) {
            addVertex(dest);
        }
        map.get(source).add(dest);
        if (bidirectional) {
            map.get(dest).add(source);
        }
    }

    /**
     * returns number of vertices
     * @return
     */
    public int getVertexCount() {
        return map.size();
    }

    /**
     * returns number of edges
     * @param bidirection
     * @return
     */
    public int getEdgeCount(boolean bidirection) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection) {
            count /= 2;
        }
        return count;
    }

    /**
     * checks for a vertex
     * @param vertex
     * @return
     */
    public boolean hasVertex(T vertex) {
        if (map.containsKey(vertex)) {
            return true;
        }
        return false;
    }

    /**
     * checks for an edge
     * @param src
     * @param dest
     * @return
     */
    public boolean hasEdge(T src, T dest) {
        if (map.get(src).contains(dest)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T vertex : map.keySet()) {
            stringBuilder.append(vertex.toString() + ": ");
            for (T adj : map.get(vertex)) {
                stringBuilder.append(adj.toString() + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        //Graph with string nodes
        GenericGraph<String> graphString = new GenericGraph<String>();

        graphString.addEdge("Shivani", "Job", true);
        graphString.addEdge("Gagan", "Job", true);
        graphString.addEdge("Gagan", "Shivani", true);
        graphString.addEdge("Amazon", "Job", true);
        graphString.addEdge("FaceBook", "Amazon", true);

        System.out.println("Graph:\n" + graphString.toString());
        System.out.println(graphString.hasVertex("Hello"));
        System.out.println(graphString.hasVertex("Shivani"));
        System.out.println(graphString.hasEdge("Shivani", "Gagan"));
        System.out.println(graphString.hasEdge("Gagan", "Shivani"));
        System.out.println("The graph has " + graphString.getVertexCount() + " vertices");
        System.out.println("The graph has " + graphString.getEdgeCount(true) + " edges.");

        //Graph with integer nodes
        GenericGraph<Integer> graphInteger = new GenericGraph<Integer>();
        graphInteger.addEdge(0, 1, true);
        graphInteger.addEdge(2, 1, true);
        graphInteger.addEdge(2, 0, true);
        graphInteger.addEdge(3, 1, true);

        System.out.println("Graph:\n" + graphInteger.toString());
        System.out.println(graphInteger.hasVertex(4));
        System.out.println(graphInteger.hasVertex(0));
        System.out.println(graphInteger.hasEdge(0, 2));
        System.out.println(graphInteger.hasEdge(2, 0));
        System.out.println("The graph has " + graphInteger.getVertexCount() + " vertices");
        System.out.println("The graph has " + graphInteger.getEdgeCount(true) + " edges.");
    }
}