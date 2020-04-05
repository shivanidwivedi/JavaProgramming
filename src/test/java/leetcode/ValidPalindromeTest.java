package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindromeTest {

    @Test
    public void isPalindrome_test(){
        Assert.assertTrue(ValidPalindrome.isPalindrome("ala"));
        Assert.assertFalse(ValidPalindrome.isPalindrome("alaa"));
        Assert.assertTrue(ValidPalindrome.isPalindrome("al a"));
        Assert.assertTrue(ValidPalindrome.isPalindrome("al:a"));
        Assert.assertTrue(ValidPalindrome.isPalindrome("090"));
        Assert.assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(false, ValidPalindrome.isPalindrome("race a car"));
    }
}
