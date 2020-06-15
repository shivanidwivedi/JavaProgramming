package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 13/06/20
 * @project JavaProgramming
 */
public class BouquetsTest {

    @Test
    public void minDays() {
        Assert.assertEquals(3,Bouquets.minDays(new int[]{1,10,3,10,2},3,1));
      //  Assert.assertEquals(12,Bouquets.minDays(new int[]{7,7,7,7,12,7},2,3));
       // Assert.assertEquals(-1,Bouquets.minDays(new int[]{7,7,7,7,12},2,3));
    }
}