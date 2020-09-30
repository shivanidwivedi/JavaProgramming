package ctcibook.treegraph;

/**
 * @author shivanidwivedi on 30/09/20
 * @project JavaProgramming
 *
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with
 * hundreds of nodes. Create an algorithm to decide ifT2 is a subtree ofTl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree ofn
 * is identical to T2. That is, if you cut off the tree at node n, the two trees would be
 * identical.
 */
public class Subtree {
    public boolean checkTree(BinaryTreeNode t1, BinaryTreeNode t2){
        if (t2 == null){ //The empty tree is always a subtree
            return true;
        }
        return subtree(t1,t2);
    }

    public boolean subtree(BinaryTreeNode t1, BinaryTreeNode t2){
        if(t1 == null){
            return false; //big tree empty & subtree still not found
        }
        if(t1.val == t2.val){
            if (matchTree(t1,t2)){
                return true;
            }
        }
        return subtree(t1.left, t2) || subtree(t1.right, t2);
    }

    public boolean matchTree(BinaryTreeNode t1, BinaryTreeNode t2){
        if (t1 == null && t2 == null){
            return true; //nothing left in the subtree
        }
        if(t1 != null || t2 != null){
            return false;
        }
        if(t1.val != t2.val){ //data doesn't match
            return false;
        }
        return matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right);
    }
}
