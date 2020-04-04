package leetcode.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 01/04/20
 * @project JavaProgramming
 */
public class SymmetricTree {
    //Iterative solution
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.value != t2.value) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    //
    public boolean isSymmetricRecursive(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.value == t2.value)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
