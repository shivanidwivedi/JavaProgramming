package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 13/04/20
 * @project JavaProgramming
 */
public class ContiguousArrayTest {
@Test
    public void findMaxLength_test(){
    Assert.assertEquals(2, ContiguousArray.findMaxLength(new int[]{0,1}));
    Assert.assertEquals(2, ContiguousArray.findMaxLength(new int[]{0,1,0}));
}
    @Test
    public void findMaxLengthHM_test(){
        Assert.assertEquals(6, ContiguousArray.findMaxlengthHM(new int[]{0,0,0,1,1,1,0}));
        Assert.assertEquals(4, ContiguousArray.findMaxlengthHM(new int[]{0,1,0,0,1}));
        Assert.assertEquals(2, ContiguousArray.findMaxlengthHM(new int[]{0,1}));
        Assert.assertEquals(2, ContiguousArray.findMaxlengthHM(new int[]{0,1,0}));
        Assert.assertEquals(4, ContiguousArray.findMaxlengthHM(new int[]{0,1,0,0,1,0}));
        Assert.assertEquals(4, ContiguousArray.findMaxlengthHM(new int[]{0,0,1,1}));

    }
}