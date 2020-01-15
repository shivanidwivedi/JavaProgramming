package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class HeightCheckerTest {

    @Test
    public void heightChecker_test(){
        Assert.assertEquals(HeightChecker.heightChecker(new Integer[]{}), 0);
        Assert.assertEquals(HeightChecker.heightChecker(new Integer[]{4}), 0);
        Assert.assertEquals(HeightChecker.heightChecker(new Integer[]{4,2}), 2);
        Assert.assertEquals(HeightChecker.heightChecker(new Integer[]{1,1,3,2,3,3}), 2);
        Assert.assertEquals(HeightChecker.heightChecker(new Integer[]{1,1,1,1}), 0);
        Assert.assertEquals(HeightChecker.heightChecker(new Integer[]{1,1,4,2,1,3}), 3);

    }
}
