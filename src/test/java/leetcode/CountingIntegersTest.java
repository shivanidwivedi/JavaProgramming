package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 */
public class CountingIntegersTest {
    @Test
    public void countElements_test(){
        Assert.assertEquals(2, CountingIntegers.countElements(new int[]{1,2,3}));
        Assert.assertEquals(0, CountingIntegers.countElements(new int[]{1,1,3,3,5,5,7,7}));
        Assert.assertEquals(3, CountingIntegers.countElements(new int[]{1,3,2,3,5,0}));
        Assert.assertEquals(2, CountingIntegers.countElements(new int[]{1,1,2,2}));
        Assert.assertEquals(1, CountingIntegers.countElements(new int[]{2,9,0,7,6,2,7,7,0}));
    }
}