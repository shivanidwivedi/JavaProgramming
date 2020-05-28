package leetcode.Trees;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 28/05/20
 * @project JavaProgramming
 * Build binary tree from preorder and inorder.
 * TC: O(N), SC: O(N)- we build entire tree
 */
public class BTreePreInOrder {
    int pIndex = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        this.inorder = inorder;

        int iIndex = 0;
        //build hashmap from inorder array, (val,index)
        for(int val : inorder){
            indexMap.put(val,iIndex++);
        }
        return helper(0,inorder.length);
    }

    private TreeNode helper(int iLeft, int iRight){
        if (iLeft == iRight) return null;
        int root_val = preorder[pIndex];
        TreeNode root = new TreeNode(root_val);
        int index = indexMap.get(root_val);
        root.left = helper(iLeft,index);
        root.right = helper(index+1, iRight);
        return root;
    }
}


