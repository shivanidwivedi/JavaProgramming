package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 06/04/20
 * @project JavaProgramming
 */
public class RottingOrangesTest {

    @Test
    public void orangesRotting_test(){
        Assert.assertEquals(4,RottingOranges.orangesRotting(new int[][]
                {{2,1,1},
                        {1,1,0},
                        {0,1,1}}));

        Assert.assertEquals(-1,RottingOranges.orangesRotting(new int[][]
                {{2,1,1},
                        {0,1,1},
                        {1,0,1}}));

        Assert.assertEquals(0,RottingOranges.orangesRotting(new int[][]
                {{0,2}}));
    }
}