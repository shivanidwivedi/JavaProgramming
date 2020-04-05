package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void reverseStr_test(){
        Assert.assertArrayEquals(ReverseString.reverseStr(new char[]{'a','b','c','d'}), new char[]{'d','c','b','a'});
        Assert.assertArrayEquals(ReverseString.reverseStr(new char[]{}), new char[]{});
        Assert.assertArrayEquals(ReverseString.reverseStr(new char[]{'a'}), new char[]{'a'});
    }
}
