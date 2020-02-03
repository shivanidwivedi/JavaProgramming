package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shivanidwivedi on 25/01/20
 * @project JavaProgramming
 */
public class ArrayDuplicatesTest {

    @Test
    public void findDuplicates_test(){
        Assert.assertEquals("[2, 3]",ArrayDuplicates.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));

    }
}
