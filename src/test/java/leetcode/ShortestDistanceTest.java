package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 19/01/20
 * @project JavaProgramming
 */
public class ShortestDistanceTest {
    @Test
    public void shortestDistance_test(){
        Assert.assertEquals(3, ShortestDistance.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding","practice"));
        Assert.assertEquals(1, ShortestDistance.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes","coding"));
    }

    @Test
    public void shortestDistanceOnePass_test(){
        Assert.assertEquals(3, ShortestDistance.shortestDistanceOnePass(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding","practice"));
        Assert.assertEquals(1, ShortestDistance.shortestDistanceOnePass(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes","coding"));
    }
}
