package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 12/07/20
 * @project JavaProgramming
 */
public class MinAddValidParenthesisTest {

    @Test
    public void minAddToMakeValid() {
        Assert.assertEquals(0, MinAddValidParenthesis.minAddToMakeValid(""));
        Assert.assertEquals(0, MinAddValidParenthesis.minAddToMakeValid("()"));
        Assert.assertEquals(1, MinAddValidParenthesis.minAddToMakeValid("(()"));
        Assert.assertEquals(3, MinAddValidParenthesis.minAddToMakeValid("((("));
        Assert.assertEquals(4, MinAddValidParenthesis.minAddToMakeValid("()))(("));
    }
}