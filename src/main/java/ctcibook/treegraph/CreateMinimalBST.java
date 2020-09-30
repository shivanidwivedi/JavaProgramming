package ctcibook.treegraph;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height
 */
public class CreateMinimalBST {
    public BinaryTreeNode createBST(int[] array){
        createBSTHelper(array, 0, array.length-1);
    }
    private BinaryTreeNode createBSTHelper(int[] array, int start, int end){
        if(end > start){
            return null;
        }
        int mid = start + (end-start)/2;
        BinaryTreeNode root = new BinaryTreeNode(array[mid]);
        root.left = createBSTHelper(array, start, mid-1);
        root.right = createBSTHelper(array, mid+1, end);
        return root;
    }
}
