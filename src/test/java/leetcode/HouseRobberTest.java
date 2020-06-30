package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 30/06/20
 * @project JavaProgramming
 */
public class HouseRobberTest {

    @Test
    public void rob() {
        Assert.assertEquals(4, HouseRobber.rob(new int[]{1,2,3,1}));
        Assert.assertEquals(12, HouseRobber.rob(new int[]{2,7,9,3,1}));
    }
}