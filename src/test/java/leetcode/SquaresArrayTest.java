package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SquaresArrayTest {

    @Test
    public void squareOfArray_test(){
        Assert.assertEquals(Arrays.toString(SquaresArray.squareOfArray(new int[]{})), Arrays.toString(new int[]{}));
        Assert.assertEquals(Arrays.toString(SquaresArray.squareOfArray(new int[]{-1})), Arrays.toString(new int[]{1}));
        Assert.assertEquals(Arrays.toString(SquaresArray.squareOfArray(new int[]{-4,-1,0,3,10})), Arrays.toString(new int[]{0,1,9,16,100}));
    }
}
