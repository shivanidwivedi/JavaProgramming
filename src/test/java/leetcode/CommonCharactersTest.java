package leetcode;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class CommonCharactersTest {

    @Test
    public void commonChars_test(){

        Assert.assertEquals(Arrays.asList(new String[]{"e","l","l"}),
                CommonCharacters.commonCharsByAscii(new String[]{"bella","label","roller"}));
        Assert.assertEquals(Arrays.asList(new String[]{"c","o"}),
                CommonCharacters.commonCharsByAscii(new String[]{"cool","lock","cook"}));
    }
}
