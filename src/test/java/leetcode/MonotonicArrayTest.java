package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 20/05/20
 * @project JavaProgramming
 */
public class MonotonicArrayTest {

    @Test
    public void isMonotonic() {
        Assert.assertTrue(MonotonicArray.isMonotonic(new int[]{1,2,2,3}));
        Assert.assertTrue(MonotonicArray.isMonotonic(new int[]{6,5,4,4}));
        Assert.assertFalse(MonotonicArray.isMonotonic(new int[]{1,3,2}));
        Assert.assertFalse(MonotonicArray.isMonotonic(new int[]{1,2,4,3}));
        Assert.assertTrue(MonotonicArray.isMonotonic(new int[]{1}));
    }
}