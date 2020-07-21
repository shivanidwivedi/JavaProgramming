package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 21/07/20
 * @project JavaProgramming
 */
public class DecodeStringTest {

    @Test
    public void decodeString() {
        Assert.assertEquals("aaabcbc", DecodeString.decodeString("3[a]2[bc]"));
        Assert.assertEquals("abcabccdcdcdef", DecodeString.decodeString("2[abc]3[cd]ef"));
        Assert.assertEquals("abccdcdcdxyz", DecodeString.decodeString("abc3[cd]xyz"));

    }
}