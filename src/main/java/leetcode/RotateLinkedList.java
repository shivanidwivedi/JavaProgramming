package leetcode;

/**
 * @author shivanidwivedi on 08/06/20
 * @project JavaProgramming
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = size(head);
        k = k % n;
        if(k==0) return head;
        ListNode current = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 1;
        while(count != n-k+1){
            current = current.next;
            count++;
            dummy = dummy.next;
        }
        dummy.next = null;
        ListNode temp = head;
        head = current;


        while(current.next != null){
            current = current.next;

        }
        System.out.println(current.val);
        current.next = temp;
        System.out.println(current.next.val);
        return head;
    }

    private int size(ListNode head){
        ListNode current = head;
        int n = 0;
        while(current != null){
            n++;
            current = current.next;
        }
        return n;
    }
}
