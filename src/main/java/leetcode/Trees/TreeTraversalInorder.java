package leetcode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author shivanidwivedi on 09/02/20
 * @project JavaProgramming
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */

//Recursive solution

public class TreeTraversalInorder {
    public List<Integer> inorderTraversalRecursive(TreeNode root){
        List<Integer> list = new LinkedList<>();
        addNode(list,root);
        return list;
    }

    public void addNode(List<Integer> list, TreeNode root){
        if (root == null){
            return;
        }
        addNode(list,root.left);
        list.add(root.value);
        addNode(list,root.right);
    }


//Iterative Solution
    public List<Integer> inorderTraversalIterative(TreeNode root){
        List <Integer> output = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();
            output.add(current.value);
            current=current.right;
        }
        return output;
    }
}
