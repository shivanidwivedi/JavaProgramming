package leetcode;

/**
 * @author shivanidwivedi on 10/09/20
 * @project JavaProgramming
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || k > getLen(head)){
            return head;
        }
        ListNode current = head;
        ListNode next = null, prev = null;
        int t = 0;
        while(current != null && t < k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            t++;
        }
        if(next != null){
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }

    public int getLen(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }
}
