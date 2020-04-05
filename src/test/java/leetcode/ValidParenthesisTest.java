package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesisTest {

    @Test
    public void isValidParenthesis_test(){

        Assert.assertFalse(ValidParenthesis.isValidParenthesis(""));
        Assert.assertFalse(ValidParenthesis.isValidParenthesis("[[["));
        Assert.assertTrue(ValidParenthesis.isValidParenthesis("[[[{}]]]"));
        Assert.assertFalse(ValidParenthesis.isValidParenthesis("[[[{}]"));
        Assert.assertTrue(ValidParenthesis.isValidParenthesis("()"));
        Assert.assertTrue(ValidParenthesis.isValidParenthesis("(){}[]"));
        Assert.assertTrue(ValidParenthesis.isValidParenthesis("(([)])"));
        Assert.assertFalse(ValidParenthesis.isValidParenthesis("))"));
        //TODO: fix this
        Assert.assertFalse(ValidParenthesis.isValidParenthesis("(]"));

    }
}
