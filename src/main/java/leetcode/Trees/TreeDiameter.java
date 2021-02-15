package leetcode.Trees;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
//Time Complexity: O(N). We visit every node once.
//Space Complexity: O(N), the size of our implicit call stack during our depth-first search.

public class TreeDiameter {
    int diameter;
    TreeNode root;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode node){
        if(node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeDiameter tree = new TreeDiameter();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        Assert.assertEquals(3, tree.diameterOfBinaryTree(tree.root));
    }
}
