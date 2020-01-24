package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 22/01/20
 * @project JavaProgramming
 */
public class MissingNumberTest {

    @Test
    public void missingNumber_test(){
        Assert.assertEquals(2, MissingNumber.missingNumber(new int[]{3,0,1}));
        Assert.assertEquals(1, MissingNumber.missingNumber(new int[]{0,2}));
        Assert.assertEquals(1, MissingNumber.missingNumber(new int[]{0}));
        Assert.assertEquals(0, MissingNumber.missingNumber(new int[]{1,2}));
        Assert.assertEquals(8, MissingNumber.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    @Test
    public void missingNumberGuass_test(){
        Assert.assertEquals(2, MissingNumber.missingNumberSinglePass(new int[]{0,1}));
        Assert.assertEquals(2, MissingNumber.missingNumberSinglePass(new int[]{3,0,1}));
        Assert.assertEquals(1, MissingNumber.missingNumberSinglePass(new int[]{0,2}));
        Assert.assertEquals(1, MissingNumber.missingNumberSinglePass(new int[]{0}));
        Assert.assertEquals(8, MissingNumber.missingNumberSinglePass(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
