package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void longestPalindrome_test(){
        Assert.assertEquals(LongestPalindromicSubstring.longestPalindrome("babad"), "bab");
        Assert.assertEquals(LongestPalindromicSubstring.longestPalindrome("ababababa"), "ababababa");
        Assert.assertEquals(LongestPalindromicSubstring.longestPalindrome("a"), "a");
        Assert.assertEquals(LongestPalindromicSubstring.longestPalindrome(""),"");
    }
}
