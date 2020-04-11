package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 11/04/20
 * @project JavaProgramming
 */
public class SpiralMatrixTest {
    @Test
    public void spiralOrder_test() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), SpiralMatrix.spiralOrder(new int[][]
                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}));

        Assert.assertEquals(Arrays.asList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10), SpiralMatrix.spiralOrder(new int[][]
                {{1, 2, 3, 4},
                        {5, 6, 7 ,8},
                        {9,10,11,12},
                        {13,14,15,16}}));

    }

}