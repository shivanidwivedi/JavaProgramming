package dataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 05/04/20
 * @project JavaProgramming
 * Level Order traversal of binary tree
 */
public class LevelOrderTraversal {
    // Method-1: using queue

    public static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    //Method-2: print level by level using depth
    public static void printLevelOrder1(Node root) {
        int h = height(root);
        for (int i = 1; i <= h; i++){
            printGivenLevel(root,i);
        }

    }
    private static int height(Node root){
        if(root == null){
            return 0;
        }else{
            int lheight = height(root.left);
            int rheight = height(root.right);
          if (lheight > rheight) return lheight+1;
          return rheight+1;
        }
    }
    private static void printGivenLevel(Node root, int level){
        if(root == null){
            return;
        }if (level == 1){
            System.out.print(root.data+" ");
        }else if(level > 1){
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
}
