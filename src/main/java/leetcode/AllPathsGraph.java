package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 24/07/20
 * @project JavaProgramming
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 * Time Complexity, Space Complexity: O(2^N * N), every time we add a new node the number of paths would double
 */
public class AllPathsGraph {
    List<List<Integer>> result;
    private int target;
    private int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length == 0) return result;
        target = graph.length - 1;
        this.graph = graph;
        result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backtrack(0, path);
        System.out.print(result);
        return result;

    }

    private void backtrack(int currentNode, LinkedList<Integer> path){
        if(currentNode == target) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for(int nextNode : graph[currentNode]){
            path.addLast(nextNode);
            backtrack(nextNode, path);
            path.removeLast();
        }
    }

    public static void main(String s[]){
        AllPathsGraph allPathsGraph = new AllPathsGraph();
        allPathsGraph.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}});
    }
}
