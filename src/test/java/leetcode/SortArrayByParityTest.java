package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortArrayByParityTest {

    @Test
    public void sortArrayByParity_test(){
        Assert.assertEquals(Arrays.toString(SortArrayByParity.sortArrayByParity(new int[]{})), Arrays.toString(new int[]{}));
        Assert.assertEquals(Arrays.toString(SortArrayByParity.sortArrayByParity(new int[]{1,2,3})), Arrays.toString(new int[]{1,2,3}));
        Assert.assertEquals(Arrays.toString(SortArrayByParity.sortArrayByParity(new int[]{4,2,5,7})), Arrays.toString(new int[]{4,5,2,7}));
    }

}
