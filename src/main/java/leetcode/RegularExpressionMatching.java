package leetcode;

/**
 * @author shivanidwivedi on 08/09/20
 * @project JavaProgramming
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()){ // if both are empty, return true
            return true;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1]; // make boolean matrix
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) { // fill first row, if pattern is *, go back 2 columns
            if (pattern[i-1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        //start filling the matrix
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(pattern[j-1] == '.' || str[i-1] == pattern[j-1]){ // if both are same chars or if pattern is '.', put diagonal value.
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern[j-1] == '*'){ // if pattern is *, go back 2 columns and put the value, if the value is false got to next line
                    dp[i][j] = dp[i][j-2];
                    if(pattern[j-2] == str[i-1] || pattern[j-2] == '.'){ //check the previous pattern char, if it matches str char , then put with one row above.
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                }else{
                    dp[i][j] = false; // otherwise false
                }
            }
        }
        return dp[m][n]; // the last element of matrix
    }

    public static void main(String[] s){
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("mississippi","mis*is*p*."));
        System.out.println(isMatch("",""));
    }
}
