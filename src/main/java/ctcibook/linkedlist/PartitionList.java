package ctcibook.linkedlist;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Write code to partition a linked list around a value x, such that all nodes less than x
 * come before alt nodes greater than or equal to x.
 *
 * Rather than shifting and swapping
 * elements, we can actually create two different linked lists: one for elements less than x,
 * and one for elements greater than or equal to x
 */
public class PartitionList {
    public LinkedListNode partition(LinkedListNode head, int x){
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;
        while (head != null){
            LinkedListNode next = head.next;
            head.next = null;
            if (head.val < x){
                if(beforeStart == null){
                    beforeStart = head;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            }else {
                if (afterStart == null){
                    afterStart = head;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }
        if(beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
