package leetcode.Trees;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */

/**
 * Method-1 : Using Recursion
 */
public class LowestCommonAncestor {
    //Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
    //Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be NN.

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        if(p.value == node.value || q.value == node.value){
            return node;
        }
        if(p.value > root.value && q.value > root.value){
            return lowestCommonAncestor(root.right, p,q);
        }
        else if(p.value < root.value && q.value < root.value){
            return lowestCommonAncestor(root.left, p,q);
        } else
            return root;
    }
/**
 * Method-2: Using Iterative method
 */
//Time Complexity : O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
//Space Complexity : O(1).

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while(node != null){
            if(p.value > node.value && q.value > node.value){
                node = node.right;
            }
            else if(p.value < node.value && q.value < node.value){
                node = node.left;
            } else return node;
        }
        return null;
    }
}
