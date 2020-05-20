package leetcode.Strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 25/04/20
 * @project JavaProgramming
 */
public class MaxScoreTest {

    @Test
    public void maxScore() {
        Assert.assertEquals(5, MaxScore.maxScore("011101"));
        Assert.assertEquals(5, MaxScore.maxScore("00111"));
        Assert.assertEquals(3, MaxScore.maxScore("1111"));

    }
}