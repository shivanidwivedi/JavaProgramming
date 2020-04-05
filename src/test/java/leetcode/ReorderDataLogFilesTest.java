package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shivanidwivedi on 30/01/20
 * @project JavaProgramming
 */
public class ReorderDataLogFilesTest {

    @Test
    public void reorderLogFiles_test(){
        Assert.assertEquals(new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"},
        ReorderDataLogFiles.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"}));
    }
}
