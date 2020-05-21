package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 21/05/20
 * @project JavaProgramming
 */
public class GoatLatinTest {

    @Test
    public void toGoatLatin() {
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa",GoatLatin.toGoatLatin(
                "I speak Goat Latin"
        ));
    }
}