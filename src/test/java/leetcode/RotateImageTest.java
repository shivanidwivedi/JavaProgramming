package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 16/04/20
 * @project JavaProgramming
 */
public class RotateImageTest {

    @Test
    public void rotate_test() {
        Assert.assertEquals(new int[][]{{7,4,1},{8,5,2},{9,6,3}}, RotateImage.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));

    }
}