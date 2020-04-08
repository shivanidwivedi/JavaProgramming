package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 */
public class KClosestPointsToOriginTest {
    @Test
    public void kClosest_test(){
        Assert.assertEquals(new int[][]{{-2, 2}}, KClosestPointsToOrigin.kClosest(new int[][]
                {{1,3},{-2,2}},1));
        Assert.assertEquals(new int[][]{{3, 3},{-2,4}}, KClosestPointsToOrigin.kClosest(new int[][]
                {{3,3},{5,-1},{-2,4}},2));
    }
}