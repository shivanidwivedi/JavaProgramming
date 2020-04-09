package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shivanidwivedi on 08/04/20
 * @project JavaProgramming
 */
public class WordLadderTest {
    @Test
    public void ladderLength_test(){
        Assert.assertEquals(5,WordLadder.ladderLength("hit","cog",new String[]{"hot","dot","dog","lot","log","cog"}));
        Assert.assertEquals(0,WordLadder.ladderLength("hit","cog",new String[]{"hot","dot","dog","lot","log"}));
        Assert.assertEquals(2,WordLadder.ladderLength("lost","cost",new String[]{"most","fist","lost","cost","fish"}));
    }
}