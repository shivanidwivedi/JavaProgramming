package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 16/04/20
 * @project JavaProgramming
 */
public class MedianOfSortedArraysTest {

    @Test
    public void findMedianSortedArrays_test() {
        Assert.assertEquals(2.0, MedianOfSortedArrays.findMedianSortedArrays
                (new int[]{1, 2, 3}, new int[]{}), 0);
    }
}