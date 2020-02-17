package leetcode.Strings;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 * Given a string S, return the number of substrings that have only one distinct letter.
 * LC-1180
 */
public class CountSubstrings {
    public static int countLetters(String S) {
        if (S.length() == 0 || S == null){
            return 0;
        }
        int result = 1;
        int prev = 1;
        for (int i = 1; i < S.length(); i++){
            if (S.charAt(i) == S.charAt(i - 1)){
                prev++;
            }else {
                prev = 1;
            }
            result += prev;
        }
        return result;
    }
}
