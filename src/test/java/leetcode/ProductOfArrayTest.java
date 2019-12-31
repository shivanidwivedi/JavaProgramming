package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayTest {

    @Test
    public void byDivision_test(){
        Assert.assertNull(ProductOfArray.byDivision(new int[]{}));
    }

    @Test
    public void byTwoArrays_test(){
        //Assert.assertNull(ProductOfArray.byTwoArrays(new int[]{}));
        Assert.assertArrayEquals(ProductOfArray.byTwoArrays(new int []{1,2,3,4}), new int []{24, 12, 8, 6});
        Assert.assertArrayEquals(ProductOfArray.byTwoArrays(new int []{2,3,4}), new int []{12, 8, 6});
        Assert.assertArrayEquals(ProductOfArray.byTwoArrays(new int []{-2,3,4}), new int []{12, -8, -6});
        Assert.assertArrayEquals(ProductOfArray.byTwoArrays(new int []{0,3,4}), new int []{12, 0, 0});
        Assert.assertEquals(ProductOfArray.byTwoArrays(new int[]{}), null);
        Assert.assertEquals(ProductOfArray.byTwoArrays(new int[]{1}), null);
    }
}
