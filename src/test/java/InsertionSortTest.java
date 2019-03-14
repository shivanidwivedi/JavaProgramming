package dataStructure.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

// Insertion sort test cases

public class InsertionSortTest {
    @Test
    public void test_sort()
    {
        Assert.assertEquals("[10, 20, 30, 40]", Arrays.toString(InsertionSort.sort(new int[]{20,40,30,10})));
    }
}
