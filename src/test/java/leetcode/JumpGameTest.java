package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 25/04/20
 * @project JavaProgramming
 */
public class JumpGameTest {
    @Test
    public void canJump() {
        Assert.assertEquals(true, JumpGame.canJump(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
        Assert.assertEquals(true, JumpGame.canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
        Assert.assertEquals(true, JumpGame.canJump(new int[]{2,0,0}));
        Assert.assertEquals(false, JumpGame.canJump(new int[]{2,1,0,3,4}));
        Assert.assertEquals(true, JumpGame.canJump(new int[]{10,1,1,1}));
        Assert.assertEquals(true, JumpGame.canJump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(true, JumpGame.canJump(new int[]{2}));
        Assert.assertEquals(true, JumpGame.canJump(new int[]{0}));
        Assert.assertEquals(false, JumpGame.canJump(new int[]{3,2,1,0,4}));
        Assert.assertEquals(false, JumpGame.canJump(new int[]{0,2,1,0,4}));

    }
}