package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 22/01/20
 * @project JavaProgramming
 */
public class MaxProductTest {

    @Test
    public void maximumProduct_test(){
        Assert.assertEquals(6, MaxProduct.maximumProduct(new int[]{1,2,3}));
        Assert.assertEquals(24, MaxProduct.maximumProduct(new int[]{1,4,2,3}));
        Assert.assertEquals(720, MaxProduct.maximumProduct(new int[]{-4,-3,-2,-1,60}));
    }

    @Test
    public void maximumProductSinglePass_test(){
        Assert.assertEquals(6, MaxProduct.maximumProductSinglePass(new int[]{1,2,3}));
        Assert.assertEquals(24, MaxProduct.maximumProductSinglePass(new int[]{1,4,2,3}));
        Assert.assertEquals(720, MaxProduct.maximumProductSinglePass(new int[]{-4,-3,-2,-1,60}));
        Assert.assertEquals(126, MaxProduct.maximumProductSinglePass(new int[]{7,3,1,0,0,6}));
    }

    @Test
    public void twoMin_test() {
        Assert.assertEquals("[1, 2]", Arrays.toString(MaxProduct.twoMin(new int[]{1,2,3,4,5})));
        Assert.assertEquals("[1, 1]", Arrays.toString(MaxProduct.twoMin(new int[]{1,1,1,4,5})));
        Assert.assertEquals("[-4, -3]", Arrays.toString(MaxProduct.twoMin(new int[]{-4,-3,-2,-1,60})));
    }

    @Test
    public void threeMax_test() {
        Assert.assertEquals("[5, 4, 3]", Arrays.toString(MaxProduct.threeMax(new int[]{1,2,3,4,5})));
        Assert.assertEquals("[60, -1, -2]", Arrays.toString(MaxProduct.threeMax(new int[]{-4,-3,-2,-1,60})));
        Assert.assertEquals("[7, 6, 3]", Arrays.toString(MaxProduct.threeMax(new int[]{7,3,1,0,0,6})));
    }
}
