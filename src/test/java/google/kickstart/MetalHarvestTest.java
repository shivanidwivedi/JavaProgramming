package google.kickstart;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 26/09/20
 * @project JavaProgramming
 */
public class MetalHarvestTest {

    @Test
    public void getRobotsCount() {
        Assert.assertEquals(5, MetalHarvest.getRobotsCount(new int[][]{
                {1,5},
                {6,11},
                {12,15}
        }, 3));
        Assert.assertEquals(6, MetalHarvest.getRobotsCount(new int[][]{
                {1,2},
                {3,4},
                {5,6},
                {9,12}
        }, 1));
        Assert.assertEquals(2, MetalHarvest.getRobotsCount(new int[][]{
                {1,6},
                {9,10}
        }, 5));

        Assert.assertEquals(2, MetalHarvest.getRobotsCount(new int[][]{
                {1,5},
                {10,11},
                {8,9}
        }, 5));

        Assert.assertEquals(3, MetalHarvest.getRobotsCount(new int[][]{
                {1,2},
                {3,5},
                {13,14}
        }, 2));


    }
}