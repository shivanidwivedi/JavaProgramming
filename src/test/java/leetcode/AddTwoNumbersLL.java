package leetcode;


import java.util.Stack;

/**
 * @author shivanidwivedi on 21/05/20
 * @project JavaProgramming
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbersLL {
    public LListNode addTwoNumbers(LListNode l1, LListNode l2) {
        Stack<LListNode> stack1 = new Stack();
        Stack<LListNode> stack2 = new Stack();
        LListNode temp1 = l1;
        while(temp1 != null){
            stack1.push(temp1);
            temp1 = temp1.next;
        }
        LListNode temp2 = l2;
        while(temp2 != null){
            stack2.push(temp2);
            temp2 = temp2.next;
        }
        LListNode dummy = new LListNode(-1);
        int sum = 0, carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            sum = val1 + val2 + carry;
            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            LListNode node = new LListNode(sum);
            LListNode next = dummy.next;
            node.next = next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
class LListNode{
    int val;
     LListNode next;
      LListNode() {}
      LListNode(int val) { this.val = val; }
}
