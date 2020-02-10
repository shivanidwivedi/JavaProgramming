package leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 09/02/20
 * @project JavaProgramming
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */

//Recursive solution
public class TreeTraversalPostorder {
    public List<Integer> postorderTraversalRecursive(TreeNode root){
        List<Integer> list = new LinkedList<>();
        addNode(list,root);
        return list;
    }

    public void addNode(List<Integer> list, TreeNode root){
        if (root == null){
            return;
        }
        addNode(list,root.left);
        addNode(list,root.right);
        list.add(root.value);
    }

    //Iterative solution

    public List<Integer> postorderTraversalIterative(TreeNode root){
        LinkedList <Integer> output = new LinkedList<>();
        LinkedList <TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pollLast();
            output.addFirst(node.value);
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
        }
        return output;
    }
}
