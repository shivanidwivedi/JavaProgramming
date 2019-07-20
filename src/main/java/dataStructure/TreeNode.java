package dataStructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList();
        LinkedList<TreeNode> stack = new LinkedList();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pollLast();
            output.add(current.val);

            if ((current.right) != null) {
                stack.add(current.right);
            }

            if ((current.left) != null) {
                stack.add(current.left);
            }
        }
        return output;
    }
}