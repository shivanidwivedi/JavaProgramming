package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 01/04/20
 * @project JavaProgramming
 */
public class SingleNumberTest {

    @Test
    public void singleNumber_test(){
        Assert.assertEquals(1, SingleNumber.singleNumber(new int[]{2,2,1}));
    }
}
