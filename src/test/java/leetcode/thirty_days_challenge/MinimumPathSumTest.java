package leetcode.thirty_days_challenge;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 18/04/20
 * @project JavaProgramming
 */
public class MinimumPathSumTest {

    @Test
    public void minPathSum_test() {
        Assert.assertEquals(7, MinimumPathSum.minPathSum(new int[][]
                {{1,3,1},{1,5,1},{4,2,1}}));
        Assert.assertEquals(3, MinimumPathSum.minPathSum(new int[][]
                {{1,2},{1,1}}));
    }
}