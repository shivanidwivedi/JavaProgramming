package dataStructure.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

// Insertion sort test cases

public class InsertionSortTest {
    @Test
    public void test_sort()
    {   // array with n elements ordered randomly
        Assert.assertEquals("[10, 20, 30, 40]", Arrays.toString(InsertionSort.sort(new int[]{20,40,30,10})));
        //array already sorted
        Assert.assertEquals("[10, 20, 30, 40]", Arrays.toString(InsertionSort.sort(new int[]{10, 20, 30, 40})));
        //array with single element
        Assert.assertEquals("[10]", Arrays.toString(InsertionSort.sort(new int[]{10})));
        //empty array
        Assert.assertEquals("[]", Arrays.toString(InsertionSort.sort(new int[]{})));
    }
}
