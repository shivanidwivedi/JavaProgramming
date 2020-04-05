package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortByParityTest {

    @Test
    public void sortByParity_test(){
        Assert.assertEquals(Arrays.toString(SortByParity.sortByParity(new int[]{})), Arrays.toString(new int[]{}));
        Assert.assertEquals(Arrays.toString(SortByParity.sortByParity(new int[]{5})), Arrays.toString(new int[]{5}));
        Assert.assertEquals(Arrays.toString(SortByParity.sortByParity(new int[]{3,1,2,4})), Arrays.toString(new int[]{4,2,1,3}));
    }
}
