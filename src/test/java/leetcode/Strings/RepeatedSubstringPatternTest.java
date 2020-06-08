package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 07/06/20
 * @project JavaProgramming
 */
public class RepeatedSubstringPatternTest {

    @Test
    public void repeatedSubstringPatternConcat() {
        Assert.assertFalse(RepeatedSubstringPattern.repeatedSubstringPatternConcat("abcabcd"));
        Assert.assertTrue(RepeatedSubstringPattern.repeatedSubstringPatternConcat("abcabc"));
    }

    @Test
    public void repeatedSubstringPatternRK(){
        Assert.assertTrue(RepeatedSubstringPattern.repeatedSubstringPattern("abcabc"));
        Assert.assertFalse(RepeatedSubstringPattern.repeatedSubstringPattern("abcabcd"));
    }
}