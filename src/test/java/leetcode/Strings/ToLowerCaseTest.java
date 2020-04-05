package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 */
public class ToLowerCaseTest {

    @Test
    public void toLowerCase_test(){
        Assert.assertEquals("hello", ToLowerCase.toLowerCase("Hello"));
        Assert.assertEquals("here", ToLowerCase.toLowerCase("here"));
        Assert.assertEquals("lovely", ToLowerCase.toLowerCase("LOVEly"));
    }

    @Test
    public void toLowerCase2_test(){
        Assert.assertEquals("hello", ToLowerCase.toLowerCase2("Hello"));
        Assert.assertEquals("here", ToLowerCase.toLowerCase2("here"));
        Assert.assertEquals("lovely", ToLowerCase.toLowerCase2("LOVEly"));
    }
}
