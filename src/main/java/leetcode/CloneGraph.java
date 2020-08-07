package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 07/08/20
 * @project JavaProgramming
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *
 * TC: O(N), SC: O(N)
 */

//Approach : BFS
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> visited = new HashMap<>();
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        while(!q.isEmpty()){
            Node n = q.remove();
            for(Node adj : n.neighbors){
                if(!visited.containsKey(adj)){
                    visited.put(adj, new Node(adj.val, new ArrayList()));
                    q.add(adj);
                }
                visited.get(n).neighbors.add(visited.get(adj));
            }
        }
        return visited.get(node);
    }
}
class Node{
    int val;
    List<Node> neighbors;
    public Node(int val, List<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
