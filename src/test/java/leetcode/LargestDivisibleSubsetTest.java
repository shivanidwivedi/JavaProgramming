package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 13/06/20
 * @project JavaProgramming
 */
public class LargestDivisibleSubsetTest {

    @Test
    public void largestDivisibleSubset() {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        Assert.assertEquals("[5]", largestDivisibleSubset.largestDivisibleSubset(new int[]{5}).toString());
        Assert.assertEquals("[1, 2]", largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,3}).toString());
        Assert.assertEquals("[1, 3, 21]", largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,3,11,21}).toString());
        Assert.assertEquals("[4, 8, 240]", largestDivisibleSubset.largestDivisibleSubset(new int[]{4,8,10,240}).toString());
    }
}