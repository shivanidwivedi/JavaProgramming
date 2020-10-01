package ctcibook.treegraph;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one.
 */
public class BalancedBinaryTree {

    // TC: O(n2), we are calling height repeatedly therefore not an effiecien solution
    public static boolean isBalanced(BinaryTreeNode root){
        if (root == null){
            return true;
        }
        int difference = height(root.left) - height(root.right);
        if (Math.abs(difference) > 1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public static int height(BinaryTreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    //Approach-2 : This code runs in 0(N) time and 0(H) space, where H is the height of the tree.

    public static boolean isBalancedOptimised(BinaryTreeNode root){
        if (checkHeight(root) == -1){
            return false;
        }
        return true;
    }
    public static int checkHeight(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = checkHeight(root.left); //Check if left is balanced
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = checkHeight(root.right); //Check if right is balanced
        if(rightHeight == -1){
            return -1;
        }
        //Check if the current node is balanced or not
        int difference = leftHeight-rightHeight;
        if(Math.abs(difference) > 1){
            return -1;
        }
        else return 1 + Math.max(leftHeight,rightHeight);
    }
}

class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;
    BinaryTreeNode(int val){
        this.val = val;
    }
}