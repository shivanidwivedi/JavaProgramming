package codechef;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 20/04/20
 * @project JavaProgramming
 */
public class LiftMeTest {

    @Test
    public void totalFloorsTravelled() {
        Assert.assertEquals(6, LiftMe.totalFloorsTravelled(2, new int[][]{
                {1,2},
                {0,1},
                {1,0}
        }));

        Assert.assertEquals(6, LiftMe.totalFloorsTravelled(2, new int[][]{
                {1,2},
                {0,1},
                {1,0},
                {3,0}
        }));

       Assert.assertEquals(3, LiftMe.totalFloorsTravelled(1, new int[][]{
                {1,0},
                {0,0},
                {0,1}
        }));
        Assert.assertEquals(3, LiftMe.totalFloorsTravelled(1, new int[][]{
                {1,0},
                {0,0},
                {0,1},
                {-1,1}
        }));

        Assert.assertEquals(3, LiftMe.totalFloorsTravelled(1, new int[][]{
                {1,0},
                {0,0},
                {0,1},
                {2,2}
        }));
    }
}