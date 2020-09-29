package ctcibook.linkedlist;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
 * of the list. Write a function that adds the two numbers and returns the sum as a
 * linked list.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */
public class AddTwoNumbers {
    public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 != null) return l2;
        LinkedListNode head = null;
        LinkedListNode current = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = (sum > 9) ? 1 : 0;
            if(carry == 1){
                sum %= 10;
            }
            LinkedListNode node = new LinkedListNode(sum);
            if(head == null){
                head = node;
            }else{
                current.next = node;
            }
            current = node;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry == 1){
            LinkedListNode node = new LinkedListNode(1);
            current.next = node;
        }
        return head;
    }
}
