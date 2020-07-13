package leetcode;

import java.util.Stack;

/**
 * @author shivanidwivedi on 12/07/20
 * @project JavaProgramming
 *
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions )
 * so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * Example 1:
 *
 * Input: "())"
 * Output: 1
 * Example 2:
 *
 * Input: "((("
 * Output: 3
 * Example 3:
 *
 * Input: "()"
 * Output: 0
 * Example 4:
 *
 * Input: "()))(("
 * Output: 4
 */
public class MinAddValidParenthesis {
    public static int minAddToMakeValid(String S) {
        if(S.length() == 0 || S == null) return 0;
        int count = 0;
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '('){
                s.push(S.charAt(i));
            }else{
                if(!s.isEmpty()){
                    s.pop();
                }else{
                    count++;
                }
            }
        }
        while(!s.isEmpty()){
            s.pop();
            count++;
        }
        return count;
    }
//More optimized solution
    public int minAddToMakeValid_2(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}
