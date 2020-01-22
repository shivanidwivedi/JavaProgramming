package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 21/01/20
 * @project JavaProgramming
 */
public class ContainsDuplicateTest {

    @Test
    public void containsDuplicate_test(){
        Assert.assertEquals(true, ContainsDuplicate.containsDuplicate(new int[]{1,2,3,1}));
        Assert.assertEquals(false, ContainsDuplicate.containsDuplicate(new int[]{1,2,3,4}));
        Assert.assertEquals(true, ContainsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    @Test
    public void containsDuplicateHashMap_test(){
        Assert.assertEquals(true, ContainsDuplicate.containsDuplicateHashMap(new int[]{1,2,3,1}));
        Assert.assertEquals(false, ContainsDuplicate.containsDuplicateHashMap(new int[]{1,2,3,4}));
        Assert.assertEquals(true, ContainsDuplicate.containsDuplicateHashMap(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
