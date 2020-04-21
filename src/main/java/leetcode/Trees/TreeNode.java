package leetcode.Trees;

import lombok.Data;

/**
 * @author shivanidwivedi on 09/02/20
 * @project JavaProgramming
 */
@Data
class Node {
    public int value;
    Node right;
    int val;
    Node left;
    public Node(int x){
        value = x;
    }

}
