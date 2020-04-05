package leetcode;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 04/04/20
 * @project JavaProgramming
 */
public class NumberOfIslandsTest {

    @Test
    public void numIslands_test() {
        Assert.assertEquals(1, NumberOfIslands.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));

        Assert.assertEquals(3, NumberOfIslands.numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}}));
    }

}