package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 21/04/20
 * @project JavaProgramming
 */
public class TrappingRainWaterTest {

    @Test
    public void trap() {
        Assert.assertEquals(6, TrappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}