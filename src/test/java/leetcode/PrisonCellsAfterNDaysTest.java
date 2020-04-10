package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 */
public class PrisonCellsAfterNDaysTest {
    @Test
    public void prisonAfterNDays_test(){
        Assert.assertEquals(Arrays.toString(new int[]{0,0,1,1,0,0,0,0}), Arrays.toString(
                PrisonCellsAfterNDays.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7)));
       Assert.assertEquals(Arrays.toString(new int[]{0,0,1,1,1,1,1,0}), Arrays.toString(
                PrisonCellsAfterNDays.prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000)));
    }
}