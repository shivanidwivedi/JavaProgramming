package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 */
public class CountSubstringsTest {

    @Test
    public void countLetters_test(){
        Assert.assertEquals(8, CountSubstrings.countLetters("aaaba"));
        Assert.assertEquals(55, CountSubstrings.countLetters("aaaaaaaaaa"));
        Assert.assertEquals(0, CountSubstrings.countLetters(""));
        Assert.assertEquals(1, CountSubstrings.countLetters("a"));
    }
}
