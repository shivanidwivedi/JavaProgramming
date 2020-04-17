package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 */
public class RobotCircleTest {

    @Test
    public void judgeCircle_test() {
        Assert.assertEquals(false, RobotCircle.judgeCircle("LRL"));
        Assert.assertEquals(true, RobotCircle.judgeCircle("UD"));
        Assert.assertEquals(false, RobotCircle.judgeCircle("LL"));
    }
    @Test
    public void judgeCircleAnother_test() {
        Assert.assertEquals(false, RobotCircle.judgeCircleAnother("LRL"));
        Assert.assertEquals(true, RobotCircle.judgeCircleAnother("UD"));
        Assert.assertEquals(false, RobotCircle.judgeCircleAnother("LL"));
    }
}