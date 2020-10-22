package leetcode.Strings;

import java.util.Stack;

/**
 * @author shivanidwivedi on 21/10/20
 * @project JavaProgramming
 *
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParentheses {
    //Approach-1 : Brute force, [TIME LIMIT EXCEEDED]

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+2; j <= s.length(); j += 2){
                if(isValid(s.substring(i, j))){
                    maxLen = Math.max(maxLen, j-i);
                }
            }
        }
        return maxLen;
    }

    /**
     * Checks for even length substring, if it is valid or not
     * @param s
     * @return
     */
    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    //Approach-2 : Stack, TC: O(n), SC: O(n)
    public int longestValidParenthesesStack(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    //Approach-3 : Constant Space, TC: O(n), SC:O(1)
    public int longestValidParenthesesWithoutSpace(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0, right = 0, maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxLen = Math.max(maxLen, 2 * right);
            }else if(right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses longest = new LongestValidParentheses();
        System.out.println(longest.longestValidParentheses(")()())"));
        System.out.println(longest.longestValidParenthesesStack(")()())"));
        System.out.println(longest.longestValidParenthesesWithoutSpace(")()())"));
    }
}
