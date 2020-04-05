package leetcode.Tree;

import leetcode.Trees.ReverseLevelOrder;
import leetcode.Trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 31/03/20
 * @project JavaProgramming
 */
public class ReverseLevelOrderTest {

    @Test
    public void test_levelOrderBottom() {
        Assert.assertEquals("[15, 7, 9, 20, 3]", ReverseLevelOrder.levelOrderBottom(prepareTree()).toString());
    }

    /**
     * prepare test data
     * @return
     */
    private TreeNode prepareTree() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.setLeft(left);
        root.setRight(right);

        left.setRight(null);
        left.setLeft(null);

        right.setLeft(new TreeNode(15));
        right.setRight(new TreeNode(7));
        return root;
    }


}
