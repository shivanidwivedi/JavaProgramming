package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shivanidwivedi on 10/06/20
 * @project JavaProgramming
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortLinkedList {
    public ListNode sortListExtraSpace(ListNode head) {
        if(head == null){
            return null;
        }
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode current = head;
        while(current != null){
            pQueue.add(current);
            current = current.next;
        }
        ListNode newHead = pQueue.poll();
        ListNode newCurrent = newHead;
        ListNode previous = newHead;
        while(pQueue.size() > 0){
            newCurrent = pQueue.poll();
            previous.next = newCurrent;
            previous = previous.next;
        }
        newCurrent.next = null;
        return newHead;
    }

    //Less time complexity and constant space
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int[] array = new int[count];
        ListNode current = head;
        int index = 0;
        while(current != null){
            array[index] = current.val;
            current = current.next;
            index++;
        }
        Arrays.sort(array);
        index = 0;
        ListNode temp1 = head;
        while(temp1 != null){
            temp1.val = array[index];
            index++;
            temp1 = temp1.next;
        }
        return head;
    }
}
