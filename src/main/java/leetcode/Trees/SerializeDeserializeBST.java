package leetcode.Trees;

import java.util.ArrayDeque;

/**
 * @author shivanidwivedi on 12/08/20
 * @project JavaProgramming
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 */
public class SerializeDeserializeBST {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        int n = data.length();
        for(int i = 0; i < (int)(n / 4); i++){
            nums.add(stringToInt(data.substring(4 * i, 4 * i + 4)));
        }

        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    private int stringToInt(String data){
        int result = 0;
        for(char c : data.toCharArray()){
            result = (result << 8) + (int)c;
        }
        return result;
    }

    private TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums){
        if(nums.isEmpty()) return null;
        int val = nums.getLast();
        if(val < lower || val > upper) return null;

        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(lower, val, nums);
        return root;
    }

    public void postorder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(intToString(root.val));
    }

    private String intToString(int value){
        char[] bytes = new char[4];
        for(int i = 3; i > -1; i--){
            bytes[3-i] = (char) (value >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }

}
