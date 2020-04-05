package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ReplaceElementsTest {

    @Test
    public void replaceWithGreatest_test(){
        Assert.assertEquals(ReplaceElements.replaceWithGreatest(null), null);
        Assert.assertEquals(Arrays.toString(ReplaceElements.replaceWithGreatest(new int[]{5})),Arrays.toString(new int[]{-1}));
        Assert.assertEquals(Arrays.toString(ReplaceElements.replaceWithGreatest(new int[]{17,18,5,4,6,1})),Arrays.toString(new int[]{18,6,6,6,1,-1}));
        Assert.assertEquals(Arrays.toString(ReplaceElements.replaceWithGreatest(new int[]{-1,-2,8,5,4,6,1})),Arrays.toString(new int[]{8,8,6,6,6,1,-1}));
    }
}
