package leetcode.Trees;

import org.junit.Assert;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 17/10/20
 * @project JavaProgramming
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {
    int count = 0;
    int k;
    TreeNode root;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode node, int currSum){
        if(node == null){
            return;
        }
        currSum += node.val;
        if(currSum == k){
            count++;
        }

        count += map.getOrDefault(currSum - k, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        preorder(node.left, currSum);
        preorder(node.right, currSum);
        map.put(currSum, map.get(currSum) - 1);
    }

    public static void main(String[] args) {
        PathSumIII tree = new PathSumIII();

        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(-3);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(2);
        tree.root.right.right = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(3);
        tree.root.left.left.right = new TreeNode(-2);
        tree.root.left.right.right = new TreeNode(1);
        Assert.assertEquals(tree.pathSum(tree.root, 8),3);
    }
}
