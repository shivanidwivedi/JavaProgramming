package ctcibook.treegraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shivanidwivedi on 30/09/20
 * @project JavaProgramming
 *
 * Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class LCABinaryTree {
    public BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q){
        if (root == null) return null;

        if (root.val == p.val || root.val == q.val){
            return root;
        }
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        HashMap<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
        parent.put(root, null);
        while (!parent.containsKey(p) || !parent.containsKey(q)){
            BinaryTreeNode node = stack.pop();
            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        HashSet<BinaryTreeNode> set = new HashSet<>();
        while (p != null){
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
