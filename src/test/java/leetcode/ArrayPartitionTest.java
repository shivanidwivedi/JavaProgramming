package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ArrayPartitionTest {

    @Test
    public void arrayPartition_test(){
        Assert.assertEquals(ArrayPartition.arrayPartition(new int[]{}),0);
        Assert.assertEquals(ArrayPartition.arrayPartition(new int[]{-2,5}),-2);
        Assert.assertEquals(ArrayPartition.arrayPartition(new int[]{-1,-2}),-2);
        Assert.assertEquals(ArrayPartition.arrayPartition(new int[]{1,3,4,2}),4);
        Assert.assertEquals(ArrayPartition.arrayPartition(new int[]{-1}),-1);
        Assert.assertEquals(ArrayPartition.arrayPartition(new int[]{-1,-3,-4,-2}),-6);
    }
}
