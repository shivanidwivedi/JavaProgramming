package leetcode.Strings;

/**
 * @author shivanidwivedi on 07/06/20
 * @project JavaProgramming
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPatternConcat(String s) {
        return (s+s).substring(1,2*s.length()-1).contains(s);
    }

    public static boolean repeatedSubstringPattern(String s){
        char[] arr = s.toCharArray();
        int m = s.length();
        for (int i = 0; i < m / 2; i++) {
            if (m % (i + 1) != 0) continue;
            if (form(arr, i)) return true;
        }
        return false;
    }

    private static boolean form(char[] arr, int i) {
        for (int j = 2; j * (i + 1) <= arr.length; j++) {
            for (int k = 0, fr = (j - 1) * (i + 1); k <= i; k++) {
                if (arr[fr + k] != arr[k]) return false;
            }
        }
        return true;
    }
}
