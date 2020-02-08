package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 02/02/20
 * @project JavaProgramming
 */
public class SubarraySumTest {

    @Test
    public void subarraySum_test(){
        Assert.assertEquals(2,SubarraySum.subarraySum(new int[]{1,1,1},2));
        Assert.assertEquals(3,SubarraySum.subarraySum(new int[]{1,2,1,1,1},2));
    }
}
