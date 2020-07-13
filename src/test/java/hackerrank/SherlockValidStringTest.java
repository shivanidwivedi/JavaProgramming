package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 13/07/20
 * @project JavaProgramming
 */
public class SherlockValidStringTest {

    @Test
    public void isValid() {
        Assert.assertEquals("YES", SherlockValidString.isValid("abc"));
        Assert.assertEquals("YES", SherlockValidString.isValid("abcc"));
        Assert.assertEquals("NO", SherlockValidString.isValid("abcddd"));
        Assert.assertEquals("NO", SherlockValidString.isValid("abccdd"));
    }
}