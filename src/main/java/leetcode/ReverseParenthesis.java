package leetcode;

import java.util.Stack;

/**
 * @author shivanidwivedi on 20/07/20
 * @project JavaProgramming
 */
public class ReverseParenthesis {
    public static String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(sb);
                sb = new StringBuilder();
            } else if (c == ')') {
                String str = sb.reverse().toString();
                sb = st.pop();
                sb.append(str);
            } else sb.append(c);
        }
        return sb.toString();
    }
}
