package leetcode.Strings;

import com.google.inject.internal.cglib.core.$ObjectSwitchCallback;
import org.junit.Assert;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 27/10/20
 * @project JavaProgramming
 */
public class TotalSubsequences {

    /**
     *
     * @param line
     * @param words
     * @return
     */
    public int countSubsequences(String line, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubSequence(line, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubSequence(String line, String word) {
        int wordIndex = 0;
            for (int lineIndex = 0; wordIndex < word.length() && lineIndex < line.length(); lineIndex++) {
                if(line.charAt(lineIndex) == word.charAt(wordIndex)) {
                    wordIndex++;
                }
            }
        return  wordIndex == word.length();
    }

    public static void main(String[] args) {
        TotalSubsequences totalSubsequences = new TotalSubsequences();
        Assert.assertEquals(3, totalSubsequences.countSubsequences("abcdae",
                new String[] {"a","bb","acda","ae"}));
        Assert.assertEquals(5, totalSubsequences.countSubsequences("abcdae",
                new String[] {"a","bb","acda","ae", "cde", "ec", "aa"}));
        Assert.assertEquals(5, totalSubsequences.countSubsequences("aaadscgaae",
                new String[] {"a","bb","aadsc","ae", "cg", "ec", "aa"}));
    }
}
