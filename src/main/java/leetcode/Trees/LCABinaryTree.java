package leetcode.Trees;

import java.util.*;

/**
 * @author shivanidwivedi on 21/07/20
 * @project JavaProgramming
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 */
public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                parent.put(node.left,node);
                stack.push(node.left);
            }
            if(node.right != null){
                parent.put(node.right,node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while(p != null){
            ancestor.add(p);
            p = parent.get(p);
        }
        while(!ancestor.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
