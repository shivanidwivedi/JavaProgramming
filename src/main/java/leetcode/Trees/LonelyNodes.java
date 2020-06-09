package leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 09/06/20
 * @project JavaProgramming
 * In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.
 *
 * Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,4]
 * Output: [4]
 * Explanation: Light blue node is the only lonely node.
 * Node 1 is the root and is not lonely.
 * Nodes 2 and 3 have the same parent and are not lonely.
 */
public class LonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left !=null && root.right == null)
            res.add(root.left.val);
        else if(root.right !=null && root.left == null)
            res.add(root.right.val);

        res.addAll(getLonelyNodes(root.left));
        res.addAll(getLonelyNodes(root.right));

        return res;
    }
}
