package ctcibook.treegraph;

/**
 * @author shivanidwivedi on 30/09/20
 * @project JavaProgramming
 *
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
 * a binary search tree. You may assume that each node has a link to its parent.
 */
public class InorderSuccessorBST {
    /*public BinaryTreeNode inorderSuccessor(BinaryTreeNode node) {
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        while(node.parent != null && node == node.parent.right){
            node = node.parent;
        }
        return node.parent;
    }*/
}
