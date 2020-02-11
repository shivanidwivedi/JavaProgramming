package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 10/02/20
 * @project JavaProgramming
 */
public class ReverseVowelsTest {

    @Test
    public void reverseVowels_test(){
        Assert.assertEquals("holle",ReverseVowels.reverseVowels("hello"));
        Assert.assertEquals("leotcede",ReverseVowels.reverseVowels("leetcode"));
    }
}
