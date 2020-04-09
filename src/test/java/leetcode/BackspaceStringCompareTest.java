package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 */
public class BackspaceStringCompareTest {
    @Test
    public void backspaceCompare_test(){
        Assert.assertEquals(true, BackspaceStringCompare.backspaceCompare("ab#c","ad#c"));
        Assert.assertEquals(true, BackspaceStringCompare.backspaceCompare("ab##","c#d#"));
        Assert.assertEquals(true, BackspaceStringCompare.backspaceCompare("a##c","#a#c"));
        Assert.assertEquals(false, BackspaceStringCompare.backspaceCompare("a#c","b"));
    }

}