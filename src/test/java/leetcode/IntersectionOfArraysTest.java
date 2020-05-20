package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 20/05/20
 * @project JavaProgramming
 */
public class IntersectionOfArraysTest {

    @Test
    public void intersect() {
        Assert.assertEquals(Arrays.toString(new int[]{2, 2}), Arrays.toString(IntersectionOfArrays.intersect(new int[]{1,2,2,1},
                new int[]{2,2})));
        Assert.assertEquals(Arrays.toString(new int[]{9, 4}), Arrays.toString(IntersectionOfArrays.intersect(new int[]{4,9,5},
                new int[]{9,4,9,8,4})));
    }
}