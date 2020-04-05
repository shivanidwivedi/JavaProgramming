package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 */
public class SingleRowKeyboardTest {

    @Test
    public void calculateTime_test(){
        Assert.assertEquals(4,SingleRowKeyboard.calculateTime("abcdefghijklmnopqrstuvwxyz","cba"));
        Assert.assertEquals(73,SingleRowKeyboard.calculateTime("pqrstuvwxyzabcdefghijklmno","leetcode"));
    }

    @Test
    public void calculateTime2_test(){
        Assert.assertEquals(4,SingleRowKeyboard.calculateTime2("abcdefghijklmnopqrstuvwxyz","cba"));
        Assert.assertEquals(73,SingleRowKeyboard.calculateTime2("pqrstuvwxyzabcdefghijklmno","leetcode"));
    }
}
