package leetcode.Trees;

import java.util.Stack;

/**
 * @author shivanidwivedi on 08/04/20
 * @project JavaProgramming
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 * For both solutions:
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(H), where H is the height of the tree.
 */
public class RangeSumBST {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }
    void dfs(TreeNode node, int L, int R){
        if(node != null){
            if (L <= node.value && node.value <= R){
                ans += node.value;
            }
            if (L < node.value){
                dfs(node.left,L,R);
            }
            if (node.value < R){
                dfs(node.right,L,R);
            }
        }
    }
    public int rangeSumBSTIterative(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.value && node.value <= R)
                    ans += node.value;
                if (L < node.value)
                    stack.push(node.left);
                if (node.value < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
