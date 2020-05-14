package leetcode.bit_manipulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 14/05/20
 * @project JavaProgramming
 */
public class StepsReduceToZeroTest {

    @Test
    public void numberOfSteps() {
        Assert.assertEquals(6, StepsReduceToZero.numberOfSteps(14));
    }
}