package leetcode.Trees;

import java.util.LinkedList;

/**
 * @author shivanidwivedi on 09/06/20
 * @project JavaProgramming
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Time complexity : we visit each node exactly once, thus the time complexity is O(N),
 * where N is the number of nodes.
 */
public class HasPathSum {
    //Recursive approach
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null){
            if(root.val == sum){
                return true;
            }else{
                return false;
            }
        }
        return (hasPathSum(root.left,sum-root.val)) || (hasPathSum(root.right,sum-root.val));
    }
    //Iterative approach
    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if(root == null) return false;
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<Integer> sum_stack = new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(sum - root.val);
        TreeNode node;
        int currentSum;
        while(!node_stack.isEmpty()){
            node = node_stack.pollLast();
            currentSum = sum_stack.pollLast();
            if((node.right == null) && (node.left == null) && (currentSum == 0))
                return true;

            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(currentSum - node.right.val);
            }

            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(currentSum - node.left.val);
            }
        }
        return false;
    }
}
