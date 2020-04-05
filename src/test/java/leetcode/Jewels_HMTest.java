package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Jewels_HMTest {
    @Test
    public void jewelsAndStones_test(){

        Assert.assertEquals(Jewels_HM.jewelsAndStones(null,null), 0);
        Assert.assertEquals(Jewels_HM.jewelsAndStones("aA", "aAAAbbbb"), 4);
        Assert.assertEquals(Jewels_HM.jewelsAndStones("a","Ab"), 0);
        Assert.assertEquals(Jewels_HM.jewelsAndStones(null,"Ab"), 0);
        Assert.assertEquals(Jewels_HM.jewelsAndStones("a",null), 0);
        Assert.assertEquals(Jewels_HM.jewelsAndStones("aa","Ab"), 0);
        Assert.assertEquals(Jewels_HM.jewelsAndStones("aAbcdef","Abbbbdeg"), 7);
        Assert.assertEquals(Jewels_HM.jewelsAndStones("a","a"), 1);
    }
}
