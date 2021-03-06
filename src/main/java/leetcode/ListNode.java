package leetcode;

import lombok.ToString;

/**
 * @author shivanidwivedi on 08/06/20
 * @project JavaProgramming
 */
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     @Override
     public String toString() {
          return val+","+next.val;
     }
}