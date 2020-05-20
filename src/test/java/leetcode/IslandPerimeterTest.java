package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 20/05/20
 * @project JavaProgramming
 */
public class IslandPerimeterTest {

    @Test
    public void islandPerimeter() {
        Assert.assertEquals(16,IslandPerimeter.islandPerimeter(
                new int[][]{
                        {0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}
                }
        ));
    }
}