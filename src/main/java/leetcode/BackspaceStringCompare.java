package leetcode;

import java.util.Stack;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 */
//TC: o(M*N)
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        build(S);
        build(T);
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        Stack<Character> stack = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                stack.push(c);
            else if (!stack.empty())
                stack.pop();
        }
        return String.valueOf(stack);
    }

}
