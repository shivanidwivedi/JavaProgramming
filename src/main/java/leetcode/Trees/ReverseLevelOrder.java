package leetcode.Trees;

import java.util.*;

/**
 * @author shivanidwivedi on 31/03/20
 * @project JavaProgramming
 */
public class ReverseLevelOrder {

    /**
     *
     * @param root
     * @return
     */
    public static List<Integer> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new Stack<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.getRight() != null){
                queue.add(current.getRight());
            }
            if(current.getLeft() != null){
                queue.add(current.getLeft());
            }
            stack.push(current.getValue());
        }

        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }



}


