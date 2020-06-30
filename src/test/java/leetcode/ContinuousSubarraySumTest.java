package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 30/06/20
 * @project JavaProgramming
 */
public class ContinuousSubarraySumTest {

    @Test
    public void checkSubarraySum() {
        Assert.assertTrue(ContinuousSubarraySum.checkSubarraySum(new int[]{23, 2, 4, 6, 7},6));
    }
}