package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MostCommonWordTest {

    @Test
    public void mostCommonWord_test(){

        //String
        Assert.assertEquals(MostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}), "ball");
        Assert.assertEquals(MostCommonWord.mostCommonWord("Bob!",
                new String[]{"hit"}), "bob");
        //Assert.assertEquals(MostCommonWord.mostCommonWord("ball",null), "ball");
    }

    @Test
    public void split_test(){
        Assert.assertEquals(new String[]{"gagan", "mani"},MostCommonWord.splitParagraphToStrings("gagan, mani"));
        Assert.assertEquals("[bob, hit, a, ball, the, hit, ball, flew, far, after, it, was, hit]",
                Arrays.toString(MostCommonWord.splitParagraphToStrings("Bob hit a ball, the hit BALL flew far after it was hit.")));
    }
}
