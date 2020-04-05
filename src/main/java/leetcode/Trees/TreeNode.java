package leetcode.Trees;

import lombok.Data;

/**
 * @author shivanidwivedi on 09/02/20
 * @project JavaProgramming
 */
@Data
public class TreeNode {
    TreeNode right;
    int value;
    TreeNode left;
    public TreeNode(int x){
        value = x;
    }


}
