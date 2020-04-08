package dataStructure.linkedlist;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 08/04/20
 * @project JavaProgramming
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 * Example 4:
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so return null.
 */

/**
 * Method-1: Recursive
 */
//Time Complexity: O(N) where N is the number of nodes in the linked list.
//Space Complexity: O(N). If we look closely, we have the recursion stack and we also have the space complexity to keep track of nodes already cloned i.e. using the visited dictionary. But asymptotically, the complexity is O(N).
public class CopyListRandomPointer {
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (map.containsKey(head)){
            return map.get(head);
        }
        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);
        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        map.put(head,node);
        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    /**
     * Method-2: Iterative Solution
     */
    //Time Complexity : O(N) because we make one pass over the original linked list.
    //Space Complexity : O(N) as we have a dictionary containing mapping from old list nodes to new list nodes. Since there are N nodes, we have O(N) space complexity.
    // Visited dictionary to hold old node reference as "key" and new node reference as the "value"
    HashMap<Node,Node> visitedList = new HashMap<>();
    public Node copyRandomListIterative(Node head) {
        if(head == null) {
            return null;
        }
        Node oldNode = head;
        // Creating the new head node.
        Node newNode = new Node(head.val);
        visitedList.put(oldNode,newNode);
        // Iterate on the linked list until all nodes are cloned.
        while(oldNode != null){
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = getCloned(oldNode.random);
            newNode.next = getCloned(oldNode.next);
        // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedList.get(head);
    }
    public Node getCloned(Node node){
        // If the node exists then
        if(node != null){
            // Check if the node is in the visited dictionary
            if(visitedList.containsKey(node)){
                // If its in the visited dictionary then return the new node reference from the dictionary
                return visitedList.get(node);

            }else{
                // Otherwise create a new node, add to the dictionary and return it
                visitedList.put(node, new Node(node.val));
                return visitedList.get(node);
            }

        }
        return null;
    }
}
