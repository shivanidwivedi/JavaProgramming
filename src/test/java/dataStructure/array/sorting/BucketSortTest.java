package dataStructure.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

// Bucket sort test cases

public class BucketSortTest {
    @Test
    public void test_sort(){
        Assert.assertEquals("array with n elements ordered randomly","[10, 20, 30, 40]", Arrays.toString(BucketSort.sort(new int[]{20,40,30,10},40)));
        Assert.assertEquals("array already sorted","[10, 20, 30, 40]", Arrays.toString(BucketSort.sort(new int[]{10, 20, 30, 40}, 40)));
        Assert.assertEquals("array with single element","[10]", Arrays.toString(BucketSort.sort(new int[]{10}, 10)));
        Assert.assertEquals("empty array","[]", Arrays.toString(BucketSort.sort(new int[]{}, 0)));
        Assert.assertEquals("null array",null, BucketSort.sort(null, 0));
    }
}
