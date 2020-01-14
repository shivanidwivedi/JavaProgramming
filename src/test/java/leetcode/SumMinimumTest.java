package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SumMinimumTest {

    @Test
    public void sumOfDigits_test(){
        Assert.assertEquals(SumMinimum.sumOfDigits(new int[]{}),-1);
        Assert.assertEquals(SumMinimum.sumOfDigits(new int[]{0}),1);
        Assert.assertEquals(SumMinimum.sumOfDigits(new int[]{34,23,1,24,75,33,54,8}),0);
        Assert.assertEquals(SumMinimum.sumOfDigits(new int[]{34,23,10,24,75,33,54,8}),1);
        Assert.assertEquals(SumMinimum.sumOfDigits(new int[]{99,77,33,66,55}),1);
    }
}
