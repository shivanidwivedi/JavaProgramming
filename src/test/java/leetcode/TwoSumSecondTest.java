package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 22/01/20
 * @project JavaProgramming
 */
public class TwoSumSecondTest {

    @Test
    public void twoSumHashMap_test(){
        Assert.assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(TwoSumSecond.twoSumHashMap(new int[]{2,7,11,15}, 9)));
        Assert.assertEquals(Arrays.toString(new int[]{2,4}), Arrays.toString(TwoSumSecond.twoSumHashMap(new int[]{2,3,6,7,15}, 10)));
    }

    @Test
    public void twoSum_test(){
        Assert.assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(TwoSumSecond.twoSum(new int[]{2,7,11,15}, 9)));
        Assert.assertEquals(Arrays.toString(new int[]{2,4}), Arrays.toString(TwoSumSecond.twoSum(new int[]{2,7,11,15}, 10)));
    }
}
