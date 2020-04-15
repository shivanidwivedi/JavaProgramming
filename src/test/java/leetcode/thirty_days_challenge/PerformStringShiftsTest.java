package leetcode.thirty_days_challenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 14/04/20
 * @project JavaProgramming
 */
public class PerformStringShiftsTest {

    @Test
    public void stringShift() {
        Assert.assertEquals("cab", PerformStringShifts.stringShift(
                "abc",new int[][]{{0,1},{1,2}}));
        Assert.assertEquals("efgabcd", PerformStringShifts.stringShift("abcdefg",
                new int[][]{{1,1},{1,1},{0,2},{1,3}}
        ));
    }

    @Test
    public void shiftedWord_test(){
        Assert.assertEquals("cdab", PerformStringShifts.shiftedWord("abcd", 2));
        Assert.assertEquals("defabc", PerformStringShifts.shiftedWord("abcdef", 3));
    }

    @Test
    public void simplifyShifts_test(){
        Assert.assertEquals(Arrays.toString(new int[]{1,3}), Arrays.toString(PerformStringShifts.simplifyShifts(
                new int[][]{{1,1},{1,1},{0,2},{1,3}})
        ));
        Assert.assertEquals(Arrays.toString(new int[]{1,1}), Arrays.toString(PerformStringShifts.simplifyShifts(
                new int[][]{{0,1},{1,2}})
        ));
    }

    @Test
    public void getStartIndex() {
        Assert.assertEquals(1, PerformStringShifts.getStartIndex("abc",new int[]{0,1}));
        Assert.assertEquals("bca",1, PerformStringShifts.getStartIndex("abc",new int[]{0,10}));
        Assert.assertEquals(2, PerformStringShifts.getStartIndex("abc",new int[]{1,1}));
        Assert.assertEquals(0, PerformStringShifts.getStartIndex("abc",new int[]{1,3}));
        Assert.assertEquals("cab", 2, PerformStringShifts.getStartIndex("abc",new int[]{1,4}));
        Assert.assertEquals("bca", 1, PerformStringShifts.getStartIndex("abc",new int[]{1,5}));
    }
}