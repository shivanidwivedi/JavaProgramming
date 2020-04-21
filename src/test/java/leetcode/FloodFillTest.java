package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 21/04/20
 * @project JavaProgramming
 */
public class FloodFillTest {

    @Test
    public void floodFill() {
        Assert.assertEquals(new int[][]{{2,2,2},{2,2,0},{2,0,1}}, FloodFill.floodFill(new int[][]
                {{1,1,1},{1,1,0},{1,0,1}}, 1,1, 2));
    }
}