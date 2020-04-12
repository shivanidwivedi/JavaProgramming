package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 11/04/20
 * @project JavaProgramming
 */
public class CompareVersionNumbersTest {
    @Test
    public void compareVersion_test(){
        Assert.assertEquals(-1, CompareVersionNumbers.compareVersion("0.1","0.1.2.3.3"));
        Assert.assertEquals(1, CompareVersionNumbers.compareVersion("1.0.1","1"));
        Assert.assertEquals(-1, CompareVersionNumbers.compareVersion("7.5.2.4","7.5.3"));
        Assert.assertEquals(0, CompareVersionNumbers.compareVersion("1.01","1.001"));
        Assert.assertEquals(0, CompareVersionNumbers.compareVersion("1.0","1.0.0"));
    }

    @Test
    public void equals() {
        Version v1 = new Version("1.0");
        Version v2 = new Version("1.0");
        Assert.assertEquals(0, v1.compareTo(v2));
    }
}