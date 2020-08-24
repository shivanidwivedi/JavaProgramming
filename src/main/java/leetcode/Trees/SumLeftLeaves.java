package leetcode.Trees;

/**
 * @author shivanidwivedi on 24/08/20
 * @project JavaProgramming
 */
public class SumLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root != null){
            if(isLeaf(root.left)){
                sum += root.left.val;
            }else{
                sum += sumOfLeftLeaves(root.left);
            }
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    private static boolean isLeaf(TreeNode node){
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
}
