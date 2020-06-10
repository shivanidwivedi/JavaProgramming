package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 10/06/20
 * @project JavaProgramming
 */
public class RemoveDuplicatesTest {

    @Test
    public void removeDuplicates() {
        Assert.assertEquals(2, RemoveDuplicates.removeDuplicates(new int[]{1,1,2}));
        Assert.assertEquals(5, RemoveDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        Assert.assertEquals(0, RemoveDuplicates.removeDuplicates(new int[]{}));
    }
}