package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 13/07/20
 * @project JavaProgramming
 */
public class MakingAnagramsTest {

    @Test
    public void makeAnagram() {
        Assert.assertEquals(4,MakingAnagrams.makeAnagram("cde","dfg"));
    }
}