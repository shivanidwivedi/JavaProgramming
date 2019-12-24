package leetcode;

import leetcode.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void twoSum(){
        Assert.assertArrayEquals(TwoSum.twoSum(new int[]{2,5,1}, 7), new int[]{0,1});
    }
}
