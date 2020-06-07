package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 07/06/20
 * @project JavaProgramming
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        putParenthesis(n, n, new StringBuilder(), output);
        return output;
    }
    private void putParenthesis(int left, int right, StringBuilder stage, List<String> output){
        if(left == 0 && right == 0){
            output.add(stage.toString());
            return;
        }
        if(left > 0){
            stage.append("(");
            putParenthesis(left-1,right,stage,output);
            stage.setLength(stage.length()-1);
        }
        if(left < right && right > 0){
            stage.append(")");
            putParenthesis(left,right-1,stage,output);
            stage.setLength(stage.length()-1);
        }
    }
}
class Main{
    public static void main(String s[]){
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }
}
