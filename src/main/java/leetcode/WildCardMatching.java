package leetcode;

/**
 * @author shivanidwivedi on 08/09/20
 * @project JavaProgramming
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
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
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 */
public class WildCardMatching {
    public static boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()){
            return true;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        for (int i = 1; i <= n; i++) {
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 1];
            else
                dp[0][i] = false;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(pattern[j-1] == '?' || pattern[j-1] == str[i-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern[j-1] == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] s){
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("cb","?a"));

    }
}
