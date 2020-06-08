package leetcode;

/**
 * @author shivanidwivedi on 08/06/20
 * @project JavaProgramming
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * This problem is a combination of these three easy problems:
 * Middle of the Linked List.
 * Reverse Linked List.
 * Merge Two Sorted Lists.
 *
 * Time complexity: O(N). There are three steps here. To identify the middle node takes O(N) time.
 * To reverse the second part of the list, one needs N/2 operations. The final step, to merge two lists,
 * requires N/2 operations as well. In total, that results in O(N) time complexity.
 *
 * Space complexity:O(1), since we do not allocate any additional data structures.
 */
public class ReorderLinkList {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode current = slow;
        ListNode temp;
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        ListNode first = head;
        ListNode second = prev;
        while(second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
