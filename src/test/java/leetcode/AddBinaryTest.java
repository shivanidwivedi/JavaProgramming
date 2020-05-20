package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 20/05/20
 * @project JavaProgramming
 */
public class AddBinaryTest {

    @Test
    public void addBinary() {
        Assert.assertEquals("100", AddBinary.addBinary("11","1"));
        Assert.assertEquals("10101", AddBinary.addBinary("1010","1011"));
        Assert.assertEquals("100", AddBinary.addBinary("100",""));
        Assert.assertEquals("", AddBinary.addBinary("",""));
    }
}