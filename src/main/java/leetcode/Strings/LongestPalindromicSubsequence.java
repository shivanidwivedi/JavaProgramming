package leetcode.Strings;

/**
 * @author shivanidwivedi on 27/10/20
 * @project JavaProgramming
 *
 * Given a String, find the longest palindromic subsequence
 *
 * Input:
 * The first line of input contains an integer T, denoting no of test cases.
 * The only line of each test case consists of a string S(only lowercase)
 *
 * Output:
 * Print the Maximum length possible for palindromic subsequence.
 *
 * TC: O(n^2), SC: O(n^2)
 */
public class LongestPalindromicSubsequence {
    private int longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int len = 2; len <= n; len++){
            for(int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                if(len == 2 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main (String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        System.out.println(obj.longestPalindrome("bbabcbcab"));
    }
}
