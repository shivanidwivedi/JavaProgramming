package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 */
public class RomanToIntegerTest {

    @Test
    public void romanToInt() {
        Assert.assertEquals(3, RomanToInteger.romanToInt("III"));
        Assert.assertEquals(4, RomanToInteger.romanToInt("IV"));
        Assert.assertEquals(9, RomanToInteger.romanToInt("IX"));
        Assert.assertEquals(58, RomanToInteger.romanToInt("LVIII"));
        Assert.assertEquals(1994, RomanToInteger.romanToInt("MCMXCIV"));
    }
}