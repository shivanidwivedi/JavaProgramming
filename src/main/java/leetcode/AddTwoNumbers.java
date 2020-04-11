package leetcode;

/**
 * @author shivanidwivedi on 11/04/20
 * @project JavaProgramming
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public LNode addTwoNumbers(LNode l1, LNode l2) {
        int carry =0;
        LNode head = null;
        LNode current = null;
        while(l1 != null || l2 != null) {
            int sum = (l1 != null ?l1.val : 0) + (l2 != null ?l2.val : 0)+carry;
            carry = sum > 9 ? 1 : 0;
            if(carry == 1){
                sum = sum % 10;
            }

            LNode newNode = new LNode(sum);
            if(head == null){
                head = newNode;
            }
            else{
                current.next = newNode;
            }

            current = newNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }

        if(carry == 1){
            LNode newNode = new LNode(1);
            current.next = newNode;
        }
        return head;
    }
}
class LNode {
    int val;
    LNode next;
    LNode(int x) { val = x; }
}
