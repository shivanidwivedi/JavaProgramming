package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 24/04/20
 * @project JavaProgramming
 */
class MaxVowelsSubstringTest {

    @Test
    public void maxVowels() {
        Assert.assertEquals("gio", MaxVowelsSubstring.maxVowels("ncdfgion",3));
        Assert.assertEquals("eufgi", MaxVowelsSubstring.maxVowels("ncdeufgion",5));
        Assert.assertEquals("aa", MaxVowelsSubstring.maxVowels("naacdfgion",2));
        Assert.assertEquals("eiuou", MaxVowelsSubstring.maxVowels("eiuou",5));
        Assert.assertEquals("", MaxVowelsSubstring.maxVowels("n",3));
    }
}
