package leetcode;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author shivanidwivedi on 24/11/20
 * @project JavaProgramming
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op : ops){
            if(op.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }else if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }else{
                stack.push(Integer.valueOf(op));
            }
        }
        int record = 0;
        while(!stack.isEmpty()){
            record += stack.pop();
        }
        return record;
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        Assert.assertEquals(30, new String[]{"5","2","C","D","+"});
    }
}
