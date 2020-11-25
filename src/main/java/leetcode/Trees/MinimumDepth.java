package leetcode.Trees;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 03/11/20
 * @project JavaProgramming
 */
public class MinimumDepth {
    //Approach-1: Recursion, O(N), O(N)-worst case
    TreeNode root;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int depth = Integer.MAX_VALUE;
        if(root.left != null){
            depth = Math.min(minDepth(root.left), depth);
        }
        if(root.right != null){
            depth = Math.min(minDepth(root.right), depth);
        }
        return depth + 1;
    }

    public static void main(String[] args) {
        MinimumDepth tree = new MinimumDepth();

        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(-3);
        tree.root.right.left = new TreeNode(3);
        tree.root.right.right = new TreeNode(11);
        Assert.assertEquals(tree.minDepth(tree.root),2);
    }
}
