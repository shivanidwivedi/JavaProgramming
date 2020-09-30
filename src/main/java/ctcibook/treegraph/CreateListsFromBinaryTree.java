package ctcibook.treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists.
 *
 * Though we might think at first glance that this problem requires a level-by-level
 * traversal, this isn't actually necessary. We can traverse the graph any way that we'd like,
 * provided we know which level we're on as we do so.
 * We can implement a simple modification of the pre-order traversal algorithm, where we
 * pass in level + 1 to the next recursive call.The code below provides an implementation
 * using depth first search.
 */

//Both run in 0(N) time. The first solution usesO(log N) recursive calls, each of which
//adds a new level to the stack. The second solution, which is iterative, does not require
//this extra space.
public class CreateListsFromBinaryTree {
    public List<LinkedList<BinaryTreeNode>> createLevelLinkedLists(BinaryTreeNode root){
        List<LinkedList<BinaryTreeNode>> result = new ArrayList<>();
        createLevelLinkedListsHelper(root, result, 0);
        return result;
    }

    private void createLevelLinkedListsHelper(BinaryTreeNode root, List<LinkedList<BinaryTreeNode>> result, int depth){
        if (root == null) return;
        LinkedList<BinaryTreeNode> list = null;
        if(result.size() == depth){
            list = new LinkedList<BinaryTreeNode>();
            result.add(list);
        }else {
            list = result.get(depth);
        }
        list.add(root);
        createLevelLinkedListsHelper(root.left, result, depth+1);
        createLevelLinkedListsHelper(root.right, result, depth+1);
    }

    //Approach-2 : BFS
    public List<LinkedList<BinaryTreeNode>> createLevelLinkedListsBFS(BinaryTreeNode root){
        List<LinkedList<BinaryTreeNode>> result = new ArrayList<>();
        LinkedList<BinaryTreeNode> current = new LinkedList<>();
        if (root != null){
            current.add(root);
        }
        while (!current.isEmpty()){
            result.add(current);
            LinkedList<BinaryTreeNode> parents = current;
            current = new LinkedList<BinaryTreeNode>();
            for (BinaryTreeNode parent : parents){
                if (parent.left != null){
                    current.add(parent.left);
                }
                if (parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}
