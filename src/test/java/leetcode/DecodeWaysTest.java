package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 29/06/20
 * @project JavaProgramming
 */
public class DecodeWaysTest {

    @Test
    public void numDecodings() {
        Assert.assertEquals(2, DecodeWays.numDecodings("12"));
        Assert.assertEquals(3, DecodeWays.numDecodings("226"));
    }
}