package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 16/06/20
 * @project JavaProgramming
 */
public class MinimumSubarraySumTest {

    @Test
    public void minSubArrayLen() {
        Assert.assertEquals(2,MinimumSubarraySum.minSubArrayLen(
                7, new int[]{2,3,1,2,4,3}
        ));
    }
}