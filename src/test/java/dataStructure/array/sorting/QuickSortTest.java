package dataStructure.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

// Insertion sort test cases

public class QuickSortTest {
    @Test
    public void testSortUtil() throws Exception {
        Assert.assertEquals("array with n elements ordered randomly","[1, 2, 3, 4]", Arrays.toString(QuickSort.sort(new int[]{ 3, 4, 2, 1})));
        Assert.assertEquals("array with n elements in decreasing order","[1, 2, 3, 4]", Arrays.toString(QuickSort.sort(new int[]{ 4, 3, 2, 1})));
        Assert.assertEquals("array with single element","[4]", Arrays.toString(QuickSort.sort(new int[]{4})));
        Assert.assertEquals("array already sorted","[1, 2, 3, 4]", Arrays.toString(QuickSort.sort(new int[]{1,2,3,4})));
      //  Assert.assertEquals("empty array","[]", Arrays.toString(QuickSort.sort(new int[]{})));
      //  Assert.assertEquals("null array",null, QuickSort.sort(null));
    }


}
