package ctcibook.linkedlist;

import java.util.HashSet;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */

//Approach-1 : Using set, we simply iterate through the linked list, adding each element
//to a hash table. When we discover a duplicate element, we remove the element and
//continue iterating. We can do this all in one pass since we are using a linked list
    // TC : o(n), SC : O(n)

public class RemoveDuplicates {
    public static void deleteDups(LinkedListNode head){
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode prev = null;
        while(head != null){
            if(set.contains(head.val)){
                prev.next = head.next;
            }else {
                set.add(head.val);
                prev = head;
            }
            head = head.next;
        }
    }

    //Approach-2 : Using constant space,   TC : o(n2), SC : O(1)

    public static void deleteDupsConstantSpace(LinkedListNode head){
        if(head == null) return;
        LinkedListNode current = head;
        while (current != null){
            LinkedListNode runner = current;
            while (runner.next != null){
                if (runner.next.val == current.val){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}

class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode(int val){
        this.val = val;
    }
}