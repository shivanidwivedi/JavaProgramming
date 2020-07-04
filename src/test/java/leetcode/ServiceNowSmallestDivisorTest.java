package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 04/07/20
 * @project JavaProgramming
 */
public class ServiceNowSmallestDivisorTest {

    @Test
    public void smallestDivisor() {
        Assert.assertEquals(1, ServiceNowSmallestDivisor.smallestDivisor(29));
        Assert.assertEquals(2, ServiceNowSmallestDivisor.smallestDivisor(30));
        Assert.assertEquals(2, ServiceNowSmallestDivisor.smallestDivisor(18));
        Assert.assertEquals(3, ServiceNowSmallestDivisor.smallestDivisor(9));
        Assert.assertEquals(5, ServiceNowSmallestDivisor.smallestDivisor(55));
        Assert.assertEquals(1, ServiceNowSmallestDivisor.smallestDivisor(5));
    }
}