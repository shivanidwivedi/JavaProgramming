package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 26/01/20
 * @project JavaProgramming
 */
public class RotatedSortedArraySearchTest {

    @Test
    public void search(){
        Assert.assertEquals(4,RotatedSortedArraySearch.search(new int[]{4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1,RotatedSortedArraySearch.search(new int[]{4,5,6,7,0,1,2}, 3));
        Assert.assertEquals(-1,RotatedSortedArraySearch.search(new int[]{}, 5));
        Assert.assertEquals(0,RotatedSortedArraySearch.search(new int[]{1}, 1));
        Assert.assertEquals(-1,RotatedSortedArraySearch.search(new int[]{1,3}, 2));
        Assert.assertEquals(1,RotatedSortedArraySearch.search(new int[]{1,3}, 3));
        Assert.assertEquals(0,RotatedSortedArraySearch.search(new int[]{3,1}, 3));
        Assert.assertEquals(1,RotatedSortedArraySearch.search(new int[]{3,5,1}, 5));
        Assert.assertEquals(0,RotatedSortedArraySearch.search(new int[]{5,1,3}, 5));
    }

    @Test
    public void getRotationIndex_test(){
        Assert.assertEquals(4, RotatedSortedArraySearch.getRotationIndex(new int[]{4,5,6,7,0,1,2}));
        Assert.assertEquals(6, RotatedSortedArraySearch.getRotationIndex(new int[]{1,2,4,5,6,7,0}));
        Assert.assertEquals(0, RotatedSortedArraySearch.getRotationIndex(new int[]{1,3}));
        Assert.assertEquals(1, RotatedSortedArraySearch.getRotationIndex(new int[]{3,1}));
        Assert.assertEquals(1, RotatedSortedArraySearch.getRotationIndex(new int[]{5,1,3}));
    }
}
