package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 28/01/20
 * @project JavaProgramming
 */
public class ContainerMostWaterTest {

    @Test
    public void maxArea_test(){
        Assert.assertEquals(49, ContainerMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(40, ContainerMostWater.maxArea(new int[]{8,6,2,5,4,8}));
        Assert.assertEquals(4, ContainerMostWater.maxArea(new int[]{4,8}));
    }

    @Test
    public void maxAreaPointer_test(){
        Assert.assertEquals(49, ContainerMostWater.maxAreaPointer(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(40, ContainerMostWater.maxAreaPointer(new int[]{8,6,2,5,4,8}));
        Assert.assertEquals(4, ContainerMostWater.maxAreaPointer(new int[]{4,8}));
    }
}
