package dataStructure.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

// Insertion sort test cases

public class InsertionSortTest {
    @Test
    public void test_sort(){
        Assert.assertEquals("array with n elements ordered randomly","[10, 20, 30, 40]", Arrays.toString(InsertionSort.sort(new int[]{20,40,30,10})));
        Assert.assertEquals("array already sorted","[10, 20, 30, 40]", Arrays.toString(InsertionSort.sort(new int[]{10, 20, 30, 40})));
        Assert.assertEquals("array with single element","[10]", Arrays.toString(InsertionSort.sort(new int[]{10})));
        Assert.assertEquals("empty array","[]", Arrays.toString(InsertionSort.sort(new int[]{})));
        Assert.assertEquals("null array",null, InsertionSort.sort(null));
    }
}
