package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 11/06/20
 * @project JavaProgramming
 */
public class DuplicateNumberTest {

    @Test
    public void findDuplicate() {
        Assert.assertEquals(2,DuplicateNumber.findDuplicate(new int[]{1,2,4,3,2}));
    }
}