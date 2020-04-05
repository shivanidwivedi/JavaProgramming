package leetcode;

import leetcode.Strings.ReverseWords;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 16/02/20
 * @project JavaProgramming
 */
public class ReverseWordsTest {

    @Test
    public void reverseWords_test(){
        Assert.assertEquals("cba",ReverseWords.reverseWords("abc"));
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc",ReverseWords.reverseWords("Let's take LeetCode contest"));
    }

    @Test
    public void reverseWords2_test(){
        Assert.assertEquals("cba",ReverseWords.reverseWords_2("abc"));
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc",ReverseWords.reverseWords_2("Let's take LeetCode contest"));
    }
}
