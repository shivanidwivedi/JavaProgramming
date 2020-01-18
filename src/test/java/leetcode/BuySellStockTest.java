package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 17/01/20
 * @project JavaProgramming
 */
public class BuySellStockTest {

    @Test
    public void maxProfit_test(){
        Assert.assertEquals(5, BuySellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(0, BuySellStock.maxProfit(new int[]{7,6,4,3,1}));
        Assert.assertEquals(1, BuySellStock.maxProfit(new int[]{1,2}));
    }
}
