package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarrayDPTest {

    @Test
    public void maxSubArray_test(){
        Assert.assertEquals(MaximumSubarray.maxSubArray(new int[]{4, -2, 1, 6, -3}), 9);
        Assert.assertEquals(MaximumSubarray.maxSubArray(new int[]{}), -1);
        Assert.assertEquals(MaximumSubarray.maxSubArray(new int[]{-1,-1}), -1);
        Assert.assertEquals(MaximumSubarray.maxSubArray(new int[]{-1}), -1);
        Assert.assertEquals(MaximumSubarray.maxSubArray(new int[]{2,3}), 5);
    }
}
