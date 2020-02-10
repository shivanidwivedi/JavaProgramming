package leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 09/02/20
 * @project JavaProgramming
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */

//Recursive solution

public class TreeTraversalPreorder{
    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        addNode(list,root);
        return list;
    }
    static void addNode(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.value);
        addNode(list,root.left);
        addNode(list,root.right);
    }

    //Iterative Solution

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.value);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
