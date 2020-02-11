package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 */
public class SplitBalancedStringsTest {

    @Test
    public void balancedStringSplit_test(){
        Assert.assertEquals(0, SplitBalancedStrings.balancedStringSplit("R"));
        Assert.assertEquals(4, SplitBalancedStrings.balancedStringSplit("RLRRLLRLRL"));
        Assert.assertEquals(3, SplitBalancedStrings.balancedStringSplit("RLLLLRRRLR"));
        Assert.assertEquals(1, SplitBalancedStrings.balancedStringSplit("LLLLRRRR"));
        Assert.assertEquals(2, SplitBalancedStrings.balancedStringSplit("RLRRRLLRLL"));
    }
}
