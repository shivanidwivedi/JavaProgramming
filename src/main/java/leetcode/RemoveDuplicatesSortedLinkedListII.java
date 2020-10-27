package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author shivanidwivedi on 26/10/20
 * @project JavaProgramming
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * TC: O(n), SC: O(1)
 */
public class RemoveDuplicatesSortedLinkedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(head != null && head.next != null){
            if(head.val != head.next.val){
                current.next = head;
                current = current.next;
                head = head.next;
            }else{
                int val = head.val;
                while(head != null && head.val == val){
                    head = head.next;
                }
            }
        }
        current.next = head;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedLinkedListII removeList = new RemoveDuplicatesSortedLinkedListII();
        ListNode headList = new ListNode(1);
        headList.next = new ListNode(1);
        headList.next.next = new ListNode(1);
        headList.next.next.next = new ListNode(2);
        headList.next.next.next.next = new ListNode(3);
        System.out.println(removeList.deleteDuplicates(headList));
    }
}
