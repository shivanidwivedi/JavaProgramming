package leetcode.thirty_days_challenge;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 16/04/20
 * @project JavaProgramming
 */
public class ValidParenthesisStringTest {

    @Test
    public void checkValidString() {
        Assert.assertEquals(true, ValidParenthesisString.checkValidString("()"));
       Assert.assertEquals(true, ValidParenthesisString.checkValidString("(*)"));
        Assert.assertEquals(true, ValidParenthesisString.checkValidString("(*))"));
        Assert.assertEquals(true, ValidParenthesisString.checkValidString("((***))"));
        Assert.assertEquals(false, ValidParenthesisString.checkValidString("((())"));
        Assert.assertEquals(true, ValidParenthesisString.checkValidString("***))"));
        Assert.assertEquals(true, ValidParenthesisString.checkValidString("(*()"));
        Assert.assertEquals(false, ValidParenthesisString.checkValidString("*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)"));
        Assert.assertEquals(false, ValidParenthesisString.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}