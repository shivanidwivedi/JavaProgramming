package leetcode.Strings;

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
        int lastMatchedIndex = -1;
        boolean matchFound = false;
            for (int j = 0; j < word.length(); j++) {
                char wordChar = word.charAt(j);
                for(int i = 0; i < line.length(); i++) {
                    char lineChar = line.charAt(i);
                    if(wordChar == lineChar) {
                        if (i > lastMatchedIndex) {
                            lastMatchedIndex = i;
                            matchFound = true;
                            break;
                        }
                    }
                }
                if(!matchFound) {
                    return false;
                }
                matchFound = false; //reset
            }
        return true;
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
