package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 10/02/20
 * @project JavaProgramming
 */
public class RemoveVowelsTest {

    @Test
    public void removeVowels_test(){
        Assert.assertEquals("ltcdscmmntyfrcdrs",RemoveVowels.removeVowels("leetcodeisacommunityforcoders"));
        Assert.assertEquals("",RemoveVowels.removeVowels("aeiou"));
    }

    @Test
    public void removeVowelsSB_test(){
        Assert.assertEquals("ltcdscmmntyfrcdrs",RemoveVowels.removeVowelsSB("leetcodeisacommunityforcoders"));
        Assert.assertEquals("",RemoveVowels.removeVowelsSB("aeiou"));
    }
}
