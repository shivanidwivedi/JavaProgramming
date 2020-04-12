package leetcode.thirty_days_challenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 12/04/20
 * @project JavaProgramming
 */
public class LastStoneWeightTest {
    @Test
    public void calculateTwoMax_test(){
        Assert.assertEquals(1,LastStoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}