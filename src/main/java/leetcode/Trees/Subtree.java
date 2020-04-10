package leetcode.Trees;

//import apple.laf.JRSUIUtils;

//import java.util.concurrent.ScheduledExecutorService;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */

/**
 * Method-1 : Using recursion
 */
public class Subtree {
    /*
    Time complexity : O(m*n). In worst case(skewed tree) traverse function takes O(m∗n) time.
    Space complexity : O(n). The depth of the recursion tree can go up to n. n refers to the number of nodes in s.
     */
    public boolean isSubtreeRecursion(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x, TreeNode y){
        if(x == null && y == null) return true;
        if(x == null || y == null) return false;
        return(x.value == y.value) && equals(x.left,y.left) && equals(x.right, y.right);
    }
    public boolean traverse(TreeNode s, TreeNode t){
        return s != null && (equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    /**
     * Method-2 : Using Preorder traversal
     * @param s
     * @param t
     * @return
     */
    //Time complexity : O(m^2+n^2+m*n). A total of n nodes of the tree s and m nodes of tree t are traversed.
    // Assuming string concatenation takes O(k) time for strings of length k and indexOf takes O(m*n).
    //Space complexity : O(max(m,n)). The depth of the recursion tree can go up to n for tree t and m for tree s in worst case.

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorderTraverse(s);
        String tree2 = preorderTraverse(t);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorderTraverse(TreeNode t) {
        if (t == null) {
            return "null";
        }
        return "#"+t.value + " " +preorderTraverse(t.left)+" " +preorderTraverse(t.right);
    }

}

