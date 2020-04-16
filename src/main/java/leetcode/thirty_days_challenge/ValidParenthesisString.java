package leetcode.thirty_days_challenge;


import java.util.Stack;

/**
 * @author shivanidwivedi on 16/04/20
 * @project JavaProgramming
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 */

/**
 * Method-1 : Using 2 stacks
 * TC: o(n)
 * SC: o(n)
 */
public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        if (s.length() == 0 || s == null){
            return true;
        }
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            //need to push the index of the character in the stack not the character itself to maintain the order, eg : *( would be invalid string
            if (s.charAt(i) == '('){
                openBracket.push(i);
            }else if (s.charAt(i) == '*'){
                star.push(i);
            }else {
                if (openBracket.isEmpty() && star.isEmpty()){
                    return false;
                }else if (openBracket.isEmpty()){
                    star.pop();
                }else openBracket.pop();
            }
        }
        while (!openBracket.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            }else if (openBracket.peek() > star.peek()){
                return false;
            }
            else {
                openBracket.pop();
                star.pop();
            }
        }
        return true;
    }

    /**
     * Method-2 : greedy approach : TC: o(n) SC: O(1)
     * @param s
     * @return
     */
    public boolean checkValidStringGreedy(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
