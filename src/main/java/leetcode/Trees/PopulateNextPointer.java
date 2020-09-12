package leetcode.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 11/09/20
 * @project JavaProgramming
 */
public class PopulateNextPointer {
    public TNode connect(TNode root) {
        if(root == null) return null;
        Queue<TNode> q = new LinkedList<>(); /// Initialize a queue which contains only root of the tree
        q.add(root);
        while(!q.isEmpty()){ //iterates over each level
            int size = q.size(); // size of the queue
            for(int i = 0; i < size; i++){ // Iterate over all the nodes on the current level
                TNode current = q.poll();
                if(i < size-1)
                    current.next = q.peek();
                //add children to the queue
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
        }
        return root;
    }
}

class TNode{
    int val;
    TNode left;
    TNode right;
    TNode next;
    TNode(int val){
        this.val = val;
    }
}
