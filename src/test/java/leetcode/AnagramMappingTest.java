package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AnagramMappingTest {
    @Test
    public void anagramMappings_test(){
        Assert.assertEquals(AnagramMapping_HM.anagramMappings(null, null), null);
        Assert.assertEquals(AnagramMapping_HM.anagramMappings(new int[]{1,2,3}, new int[]{2,1}), null);
        Assert.assertEquals(Arrays.toString(AnagramMapping_HM.anagramMappings(new int[]{12, 28, 46, 32, 50},
                new int[]{50, 12, 32, 46, 28})),
                Arrays.toString(new int[]{1, 4, 3, 2, 0}));
    }
}
