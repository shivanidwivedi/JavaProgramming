package ctcibook.linkedlist;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Implement an algorithm to delete a node in the middle of a singly linked list, given
 * only access to that node.
 *
 * Note that this problem cannot be solved if the node to be deleted is the last node in
 * the linked list. That's ok—your interviewer wants you to point that out, and to discuss
 * how to handle this case. You could, for example, consider marking the node as dummy
 */
public class DeleteMiddleNode {
    public static boolean deleteNode(LinkedListNode node){
        if(node == null || node.next == null){
            return false;
        }
        LinkedListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return true;
    }
}
