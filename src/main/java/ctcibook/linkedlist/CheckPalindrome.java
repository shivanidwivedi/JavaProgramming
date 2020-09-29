package ctcibook.linkedlist;

import java.util.Stack;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Implement a function to check if a linked list is a palindrome.
 */
public class CheckPalindrome {
    public boolean isPalindrome(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null || fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //odd number of elements, so skip the middle element
        if(fast != null){
            slow = slow.next;
        }
        while (slow != null){
            if (slow.val != stack.peek()){
                return false;
            }else{
                slow = slow.next;
                stack.pop();
            }
        }
        return true;
    }
}
