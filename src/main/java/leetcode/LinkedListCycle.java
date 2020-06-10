package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 10/06/20
 * @project JavaProgramming
 *
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list,
 * where tail connects to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list,
 * where tail connects to the first node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
 // HashSet approach
public class LinkedListCycle {
    public ListNode detectCycleExtraSpace(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while(current != null){
            if(set.contains(current)){
                return current;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }
// Constant space

    private ListNode getIntersect(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && slow.next != null){
            fast = fast.next;
            slow = slow.next.next;
            if(fast == null){
                return fast;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = intersect;

        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
