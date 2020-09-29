package ctcibook.linkedlist;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

//This algorithm takes 0(n) time and 0(1) space.
public class RemoveKthNodeFromEnd {
    public LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
        if(head == null) return head;
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode first = head;
        LinkedListNode second = dummy;
        for(int i = 1; i <= n; i++){
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    //Approach-2 : Recursively
    public LinkedListNode removeNthFromEndRecursion(LinkedListNode head, int n, IntWrapper intWrapper) {
        if(head == null) return null;
        LinkedListNode node = removeNthFromEndRecursion(head.next, n, intWrapper);
        intWrapper.value = intWrapper.value+1;
        if (intWrapper.value == n){
            return head;
        }
        return node;
    }
}

class IntWrapper {
    public int value = 0;
}
