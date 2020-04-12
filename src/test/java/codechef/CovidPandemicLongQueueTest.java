package codechef;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 12/04/20
 * @project JavaProgramming
 */
public class CovidPandemicLongQueueTest {

    @Test
    public void covidPandemic_test(){
        Assert.assertEquals("NO", CovidPandemicLongQueue.covidPandemic(new int[]{1,0,0,1,0,0,0,0,0,1}));
        Assert.assertEquals("YES", CovidPandemicLongQueue.covidPandemic(new int[]{1,0,0,0,0,0,1}));
        Assert.assertEquals("YES", CovidPandemicLongQueue.covidPandemic(new int[]{1,0,0,0,0}));
    }
}