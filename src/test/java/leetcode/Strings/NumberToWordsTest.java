package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 13/03/20
 * @project JavaProgramming
 */
public class NumberToWordsTest {

    @Test
    public void numberToWords_test(){
        Assert.assertEquals("One Hundred Twenty Three",NumberToWords.numberToWords(123));
        Assert.assertEquals("Twelve Thousand Three Hundred Forty Five",NumberToWords.numberToWords(12345));
        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",NumberToWords.numberToWords(1234567));
        Assert.assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",NumberToWords.numberToWords(1234567891));

    }
}
