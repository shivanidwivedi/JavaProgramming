package leetcode;

/**
 * @author shivanidwivedi on 11/10/20
 * @project JavaProgramming
 *
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor
 * and successor pointers in a doubly-linked list.
 * For a circular doubly linked list, the predecessor of the first element is the last element,
 * and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation,
 * the left pointer of the tree node should point to its predecessor,
 * and the right pointer should point to its successor.
 * You should return the pointer to the smallest element of the linked list.
 *
 * Example 1:
 * Input: root = [4,2,5,1,3]
 * Output: [1,2,3,4,5]
 *
 * TC: O(N) and SC: O(log N), worst case: O(N)
 */
public class BSTCircularDLLConversion {
    CNode first = null;
    CNode last = null;

    public CNode treeToDoublyList(CNode root) {
        if(root == null){
            return root;
        }
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void helper(CNode root){
        if(root != null){
            helper(root.left);
            if(last != null){
                last.right = root;
                root.left = last;
            }else{
                first = root;
            }
            last = root;
            helper(root.right);
        }
    }
}
class CNode{
    public int val;
    public CNode left;
    public CNode right;
}