package leetcode.Trees;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 02/12/20
 * @project JavaProgramming
 */
public class LongestConsecutiveSequenceII {
    int maxVal = 0;
    TreeNode root;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxVal;
    }
    public int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[] {0,0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        maxVal = Math.max(maxVal, dcr + inr - 1);
        return new int[] {inr, dcr};
    }

    public static void main(String[] args) {
     /*   LongestConsecutiveSequenceII tree1 = new LongestConsecutiveSequenceII();

        tree1.root = new TreeNode(2);
        tree1.root.left = new TreeNode(1);
        tree1.root.right = new TreeNode(3);*/

        LongestConsecutiveSequenceII tree2 = new LongestConsecutiveSequenceII();

        tree2.root = new TreeNode(3);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(4);
        tree2.root.left.left = new TreeNode(3);
        tree2.root.left.right = new TreeNode(1);
        tree2.root.right.right = new TreeNode(5);
        tree2.root.left.right.right = new TreeNode(4);
        tree2.root.right.right.right = new TreeNode(6);
       // Assert.assertEquals(tree1.longestConsecutive(tree1.root),3);
        Assert.assertEquals(tree2.longestConsecutive(tree2.root),6);
    }
}
