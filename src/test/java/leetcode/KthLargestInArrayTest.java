package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 21/04/20
 * @project JavaProgramming
 */
public class KthLargestInArrayTest {

    @Test
    public void findKthLargest() {
        Assert.assertEquals(5,KthLargestInArray.findKthLargestHeap(
                new int[]{3,2,1,5,6,4},2
        ));
        Assert.assertEquals(4,KthLargestInArray.findKthLargestHeap(
                new int[]{3,2,3,1,2,4,5,5,6},4
        ));
    }
}