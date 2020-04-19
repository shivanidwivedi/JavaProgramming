package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 18/04/20
 * @project JavaProgramming
 */
public class ReformatTheStringTest {

    @Test
    public void reformat_test() {
        Assert.assertEquals("", ReformatTheString.reformat("a0b1c2ccc"));
        Assert.assertEquals("0a1b2c", ReformatTheString.reformat("a0b1c2"));
        Assert.assertEquals("", ReformatTheString.reformat("leetcode"));
        Assert.assertEquals("c2o0v1i9d", ReformatTheString.reformat("covid2019"));
        Assert.assertEquals("1a2b3", ReformatTheString.reformat("ab123"));
    }
}