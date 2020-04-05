package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 20/01/20
 * @project JavaProgramming
 */
public class MoveZeroesTest {

    @Test
    public void moveZeroes_test(){
        Assert.assertEquals(Arrays.toString(new int[]{1,3,12,0,0}), Arrays.toString(MoveZeroes.moveZeroes(new int[]{0,1,0,3,12})));
        Assert.assertEquals(Arrays.toString(new int[]{0,0,0}), Arrays.toString(MoveZeroes.moveZeroes(new int[]{0,0,0})));
        Assert.assertEquals(Arrays.toString(new int[]{1,3,9,7,98,12,0,0,0,0}), Arrays.toString(MoveZeroes.moveZeroes(new int[]{0,1,0,3,0, 9 ,0,7,98,12})));
    }
}
