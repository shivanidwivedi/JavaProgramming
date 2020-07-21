package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 20/07/20
 * @project JavaProgramming
 */
public class ReverseParenthesisTest {

    @Test
    public void reverseParentheses() {
        Assert.assertEquals("dcba",ReverseParenthesis.reverseParentheses(
                "(abcd)"
        ));
        Assert.assertEquals("iloveu",ReverseParenthesis.reverseParentheses(
                "(u(love)i)"
        ));
        Assert.assertEquals("leetcode",ReverseParenthesis.reverseParentheses(
                "(ed(et(oc))el)"
        ));
    }
}