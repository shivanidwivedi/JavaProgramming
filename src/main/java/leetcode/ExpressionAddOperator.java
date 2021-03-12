package leetcode;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 09/03/21
 * @project JavaProgramming
 */
public class ExpressionAddOperator {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, num, 0, target, 0, 0);
        return result;

    }
    private void dfs(StringBuilder sb, String num, int index, int target, long prev, long multi) {
        if(index == num.length()) {
            if(target == prev){
                result.add(sb.toString());
            }
            return;
        }
        for(int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && i != index) break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = sb.length();
            if(index == 0) {
                dfs(sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                dfs(sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperator obj = new ExpressionAddOperator();
        List<String> result = new ArrayList<>();
        result.add("1+2+3");
        result.add("1*2*3");
        Assert.assertEquals(result, obj.addOperators("123",6));
    }
}
