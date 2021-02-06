package dataStructure.String;

import com.google.inject.internal.cglib.proxy.$MethodInterceptor;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 06/02/21
 * @project JavaProgramming
 */
public class RabinKarp {

    private int prime = 101;

    public static void main(String[] args) {
        RabinKarp rabinKarp = new RabinKarp();
        char[] text = "shivani dwivedi".toCharArray();
        char[] pattern = "iv".toCharArray();
        char[] text1 = "lohelo lo".toCharArray();
        char[] pattern1 = "lo".toCharArray();
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(10);
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(0);
        expected1.add(4);
        expected1.add(7);
        Assert.assertEquals(expected, rabinKarp.patternSearch(text, pattern));
        Assert.assertEquals(expected1, rabinKarp.patternSearch(text1, pattern1));
    }

    public List<Integer> patternSearch(char[] text, char[] pattern){
        List<Integer> result = new ArrayList<>();
        int m = pattern.length;
        int n = text.length;
        long patternHash = createHash(pattern, m - 1);
        long textHash = createHash(text, m - 1);
        for (int i = 1; i <= n - m + 1; i++) {
            if(patternHash == textHash && checkEqual(text, i - 1, i + m - 2, pattern, 0, m - 1)) {
                result.add(i-1);
            }
            else if(i < n - m + 1) {
                textHash = recalculateHash(text, i - 1, i + m - 1, textHash, m);
            }
        }
        return result;
    }

    private long recalculateHash(char[] str,int oldIndex, int newIndex,long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash/prime;
        newHash += str[newIndex]*Math.pow(prime, patternLen - 1);
        return newHash;
    }

    private long createHash(char[] str, int end){
        long hash = 0;
        for (int i = 0 ; i <= end; i++) {
            hash += str[i]*Math.pow(prime,i);
        }
        return hash;
    }

    private boolean checkEqual(char str1[],int start1,int end1, char str2[],int start2,int end2){
        if(end1 - start1 != end2 - start2) {
            return false;
        }
        while(start1 <= end1 && start2 <= end2){
            if(str1[start1] != str2[start2]){
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }
}
