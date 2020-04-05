package dataStructure.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

// Counting sort test cases

public class CountingSortTest {
    @Test
    public void test_sort(){
        Assert.assertEquals("array with n elements ordered randomly","[1, 2, 2, 4]", Arrays.toString(CountingSort.sort(new int[]{2,4,1,2})));
        Assert.assertEquals("array with same element","[1, 1, 1, 1]", Arrays.toString(CountingSort.sort(new int[]{1,1,1,1})));
        Assert.assertEquals("array already sorted","[1, 2, 3, 4]", Arrays.toString(CountingSort.sort(new int[]{1, 2, 3, 4})));
        Assert.assertEquals("array with single element","[1]", Arrays.toString(CountingSort.sort(new int[]{1})));
        Assert.assertEquals("empty array","[]", Arrays.toString(CountingSort.sort(new int[]{})));
       // Assert.assertEquals("null array",null, CountingSort.sort(null));
    }
}