package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 21/01/20
 * @project JavaProgramming
 */
public class BuySellStockSecondTest {

    @Test
    public void maxProfit_test(){
        Assert.assertEquals(7, BuySellStockSecond.maxProfit(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(4, BuySellStockSecond.maxProfit(new int[]{1,2,3,4,5}));
        Assert.assertEquals(0, BuySellStockSecond.maxProfit(new int[]{7,6,4,3,1}));
    }
    @Test
    public void maxProfit_tes2t(){
        Assert.assertEquals(7, BuySellStockSecond.maxProfit2(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(4, BuySellStockSecond.maxProfit2(new int[]{1,2,3,4,5}));
        Assert.assertEquals(0, BuySellStockSecond.maxProfit2(new int[]{7,6,4,3,1}));
    }
}
