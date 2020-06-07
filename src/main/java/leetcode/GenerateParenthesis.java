package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 07/06/20
 * @project JavaProgramming
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        putParenthesis(n, n, new StringBuilder(), output);
        return output;
    }

    private void putParenthesis(int left, int right, StringBuilder stage, List<String> output) {
        if (left == 0 && right == 0) {
            output.add(stage.toString());
            return;
        }
        if (left > 0) {
            stage.append("(");
            putParenthesis(left - 1, right, stage, output);
            stage.setLength(stage.length() - 1);
        }
        if (left < right && right > 0) {
            stage.append(")");
            putParenthesis(left, right - 1, stage, output);
            stage.setLength(stage.length() - 1);
        }
    }

    public List<String> generateParenthesisBacktrack(int n) {
        List<String> output = new ArrayList<>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    private void backtrack(List<String> output, String current, int left, int right, int max) {
        if (current.length() == max * 2) {
            output.add(current);
            return;
        }
        if (left < max) {
            backtrack(output, current + "(", left + 1, right, max);
        }
        if (right < left) {
            backtrack(output, current + ")", left, right + 1, max);
        }
    }
}
class Main{
    public static void main(String s[]){
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
        generateParenthesis.generateParenthesisBacktrack(2);
    }
}
