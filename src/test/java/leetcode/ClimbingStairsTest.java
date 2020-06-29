package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 29/06/20
 * @project JavaProgramming
 */
public class ClimbingStairsTest {

    @Test
    public void climbStairs() {
        Assert.assertEquals(2, ClimbingStairs.climbStairs(2));
        Assert.assertEquals(3, ClimbingStairs.climbStairs(3));
    }
}