package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 15/06/20
 * @project JavaProgramming
 */
public class FirstLastPositionTest {

    @Test
    public void searchRange() {
        Assert.assertEquals(Arrays.toString(new int[]{-1,-1}), Arrays.toString(FirstLastPosition.searchRange(
                new int[]{5,7,7,8,8,10},6
        )));
        Assert.assertEquals(Arrays.toString(new int[]{3,4}), Arrays.toString(FirstLastPosition.searchRange(
                new int[]{5,7,7,8,8,10},8
        )));
    }
}