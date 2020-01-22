package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 21/01/20
 * @project JavaProgramming
 */
public class MaxConsecutiveOnesTest {

    @Test
    public void findMaxConsecutiveOnes_test(){
        Assert.assertEquals(3, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        Assert.assertEquals(5, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,1,1,1}));
        Assert.assertEquals(5, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,0,0,0,0,1,1,1,1,1}));
    }
}
