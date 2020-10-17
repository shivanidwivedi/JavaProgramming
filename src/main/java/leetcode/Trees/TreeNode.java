package leetcode.Trees;

import lombok.Data;

/**
 * @author shivanidwivedi on 09/02/20
 * @project JavaProgramming
 */
@Data
class TreeNode {
    public int value;
    TreeNode right;
    int val;
    TreeNode left;
    public TreeNode(int x){
        val = x;
        value = x;
    }

}
