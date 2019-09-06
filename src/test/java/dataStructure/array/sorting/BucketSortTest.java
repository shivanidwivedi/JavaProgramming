package dataStructure.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parameterize test: https://github.com/junit-team/junit4/wiki/parameterized-tests
 */
@RunWith(Parameterized.class)
public class BucketSortTest {

    String expectedResult;
    int[] inputList;
    int maxVal;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{20, 40, 30, 10}, 40, "[10, 20, 30, 40]"},
                {new int[]{10, 20, 30, 40}, 40, "[10, 20, 30, 40]"},
                {new int[]{10}, 10, "[10]"},
                {new int[]{}, 0, "[]"}
        });
    }

    public BucketSortTest(int[] inputList, int maxVal, String expectedResult) {
        this.inputList = inputList;
        this.maxVal = maxVal;
        this.expectedResult = expectedResult;
    }


    @Test
    public void test_sort() {
        Assert.assertEquals("array with n elements ordered randomly", expectedResult,
                Arrays.toString(BucketSort.sort(inputList, maxVal)));
    }
}
