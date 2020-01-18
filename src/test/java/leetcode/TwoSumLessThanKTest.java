package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumLessThanKTest {

    @Test
    public void twoSumLessThanK() {
        //Assert.assertEquals(58, TwoSumLessThanK.twoSumLessThanK(new int[] {34,23,1,24,75,33,54,8}, 60));
        //Assert.assertEquals(-1, TwoSumLessThanK.twoSumLessThanK(new int[] {10,20,30}, 15));

        int[] arr = new int[] {358,898,450,732,672,672,256,542,320,573,423,543,591,280,399,923,920,254,
                135,952,115,536,143,896,411,722,815,635,353,486,127,146,974,495,229,
                21,733,918,314,670,671,537,533,716,140,599,758,777,185,549};
        Assert.assertEquals(1794, TwoSumLessThanK.twoSumLessThanK(arr, 1800));
    }
}
