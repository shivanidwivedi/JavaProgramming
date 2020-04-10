package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 */
public class Search2DMatrixTest {

    @Test
    public void searchMatrix() {
        Assert.assertEquals(false, SearchInMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 13));
        Assert.assertEquals(true, SearchInMatrix.searchMatrix(new int[][]{
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3));

        Assert.assertEquals(false, SearchInMatrix.searchMatrix(new int[][]{}, 3));
        Assert.assertEquals(true, SearchInMatrix.searchMatrix(new int[][]{{1,3}}, 1));
        Assert.assertEquals(true, SearchInMatrix.searchMatrix(new int[][]{{1,2},{3},{5,6}}, 5));



    }
}