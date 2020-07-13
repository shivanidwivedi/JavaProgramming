package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shivanidwivedi on 10/07/20
 * @project JavaProgramming
 *
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
 * which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own,
 * and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Time Complexity: O(N). The iterative solution has the same time complexity as the recursive.
 * Space Complexity: O(N). Again, the iterative solution has the same space complexity as the recursive one.
 */
public class FlattenMultilevelList {

    //Approach-1: Iterative solution
    public SpecialNode flatten(SpecialNode head) {
        if(head == null) return head;
        SpecialNode dummy = new SpecialNode(0,null,head,null);
        SpecialNode current = dummy;
        SpecialNode prev = dummy;
        Deque<SpecialNode> stack = new ArrayDeque<>();
        stack.push(head);

        while(!stack.isEmpty()){
            current = stack.pop();
            prev.next = current;
            current.prev = prev;

            if(current.next != null){
                stack.push(current.next);
            }
            if(current.child != null){
                stack.push(current.child);
                current.child = null;
            }
            prev = current;
        }

        dummy.next.prev = null;
        return dummy.next;
    }
}
//special node class as it has an extra pointer child.
class SpecialNode{
    public int val;
    public SpecialNode prev;
    public SpecialNode next;
    public SpecialNode child;
        SpecialNode(int val,SpecialNode prev, SpecialNode next, SpecialNode child){
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
}