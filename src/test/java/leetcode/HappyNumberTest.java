package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumberTest {
    @Test
    public void isHappy_test(){
        Assert.assertFalse(HappyNumber.isHappy(0));
        Assert.assertTrue(HappyNumber.isHappy(7));
        Assert.assertTrue(HappyNumber.isHappy(19));
        Assert.assertFalse(HappyNumber.isHappy(2999));
    }
}
