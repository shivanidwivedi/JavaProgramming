package dataStructure.misc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 05/04/20
 * @project JavaProgramming
 */
public class GCDTest {
    @Test

    public void findGcd_test(){
        Assert.assertEquals(2, GCD.findGcd(new int[]{2,4,14},3));
        Assert.assertEquals(2, GCD.findGcd(new int[]{4,14},2));
        Assert.assertEquals(2, GCD.findGcd(new int[]{2,0},2));
        Assert.assertEquals(1, GCD.findGcd(new int[]{2,3,14},3));

    }
}