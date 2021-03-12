package leetcode.Trees;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 04/03/21
 * @project JavaProgramming
 */
public class ValidateBinaryTreeNodes {
    int count;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        count = n;
        // detect if one node has two fathers
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] == -1) {
                    parent[leftChild[i]] = i;
                } else {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] == -1) {
                    parent[rightChild[i]] = i;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // detect cycle
        for (int i = 0; i < n; i++) {
            int lc = leftChild[i], rc = rightChild[i], father = i;
            if (lc != -1 && union(parent, lc, father) ) {
                return false;
            }
            if (rc != -1 && union(parent, rc, father) ) {
                return false;
            }
        }
        // detect if it's forest instead of tree
        return count == 1;
    }
    boolean union(int[] parent, int i, int j) {
        int parent1 = find(parent, i);
        int parent2 = find(parent, j);
        parent[parent1] = parent2;
        if(parent1 != parent2){
            count--;
        }
        return parent1 == parent2;
    }
    int find(int[] parent, int i) {
        if (i != parent[i]) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public static void main(String[] args) {
        ValidateBinaryTreeNodes obj = new ValidateBinaryTreeNodes();
        Assert.assertEquals(true, obj.validateBinaryTreeNodes(
                4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}
        ));
    }
}
