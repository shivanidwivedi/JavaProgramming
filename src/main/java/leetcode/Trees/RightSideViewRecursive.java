package leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 28/12/20
 * @project JavaProgramming
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class RightSideViewRecursive {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return result;
        }
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode node, int level){
        if(level == result.size()){
            result.add(node.val);
        }
        if (node.right != null){
            helper(node.right, level + 1);
        }
        if (node.left != null){
            helper(node.left, level + 1);
        }
    }
}
