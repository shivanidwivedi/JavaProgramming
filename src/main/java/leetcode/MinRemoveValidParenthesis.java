package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author shivanidwivedi on 24/08/20
 * @project JavaProgramming
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid
 * and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 *
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 */
public class MinRemoveValidParenthesis {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> removeIndices = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else if(stack.isEmpty()){
                    removeIndices.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            removeIndices.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!removeIndices.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] s){
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("))(("));
    }
}

