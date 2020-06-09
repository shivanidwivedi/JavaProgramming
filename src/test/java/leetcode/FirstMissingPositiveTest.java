package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 09/06/20
 * @project JavaProgramming
 */
public class FirstMissingPositiveTest {

    @Test
    public void firstMissingPositive() {
        Assert.assertEquals(1, FirstMissingPositive.firstMissingPositive(new int[]{}));
        Assert.assertEquals(2, FirstMissingPositive.firstMissingPositive(new int[]{1}));
        Assert.assertEquals(2, FirstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1}));
        Assert.assertEquals(1, FirstMissingPositive.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}