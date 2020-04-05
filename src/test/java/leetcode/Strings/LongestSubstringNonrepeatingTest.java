package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 12/03/20
 * @project JavaProgramming
 */
public class LongestSubstringNonrepeatingTest {

    @Test
    public void lengthOfLongestSubstringBrute_test(){
        Assert.assertEquals(3, LongestSubstringNonrepeating.lengthOfLongestSubstringBrute("abcabcbb"));
        Assert.assertEquals(1, LongestSubstringNonrepeating.lengthOfLongestSubstringBrute("bbbbb"));
        Assert.assertEquals(3, LongestSubstringNonrepeating.lengthOfLongestSubstringBrute("pwwkew"));
    }
    @Test
    public void lengthOfLongestSubstring_test(){
        Assert.assertEquals(3, LongestSubstringNonrepeating.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, LongestSubstringNonrepeating.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, LongestSubstringNonrepeating.lengthOfLongestSubstring("pwwkew"));
    }
}
