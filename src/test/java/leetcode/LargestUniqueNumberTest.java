package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class LargestUniqueNumberTest {

    @Test
    public void largestUniqueNumber_test(){
        Assert.assertEquals(LargestUniqueNumber.largestUniqueNumber(new int[]{9,9,8,8}), -1);
        Assert.assertEquals(7, LargestUniqueNumber.largestUniqueNumber(new int[]{3,3, 7, 2, 5}) );
        Assert.assertEquals(2, LargestUniqueNumber.largestUniqueNumber(new int[]{3, 3, 7, 7, 2}));
    }

    @Test
    public void largestUniqueNumber_BySorting_test(){
        Assert.assertEquals(10, LargestUniqueNumber.largestUniqueNumber_BySorting(new int[]{11,10,11}));
        Assert.assertEquals(-1, LargestUniqueNumber.largestUniqueNumber_BySorting(new int[]{9,9,8,8}));
        Assert.assertEquals(7, LargestUniqueNumber.largestUniqueNumber_BySorting(new int[]{3,3, 7, 2, 5}) );
        Assert.assertEquals(2, LargestUniqueNumber.largestUniqueNumber_BySorting(new int[]{3, 3, 7, 7, 2}));
    }

    @Test
    public void arrayToMap_test(){
        int arr[] = {3, 3, 7, 7, 2};
        HashMap<Integer,Integer> map = LargestUniqueNumber.arrayToMap(arr);
        Assert.assertEquals(Integer.valueOf(2), map.get(3));
        Assert.assertEquals(Integer.valueOf(2), map.get(7));
        Assert.assertEquals(Integer.valueOf(1), map.get(2));
    }
}
