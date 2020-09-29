package ctcibook.linkedlist;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Given a circular linked list, implement an algorithm which returns the node at the
 * beginning of the loop.
 */
public class CircularLinkedList {
    public LinkedListNode findBeginning(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        if (fast == null || fast.next == null){
            return null;
        }
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
