package leetcode;

/**
 * @author shivanidwivedi on 26/06/20
 * @project JavaProgramming
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindromeII {
    /**
     * Approach-1 : Brute force [Time limit exceeded]
     * TC: O(N^2), SC : O(N)
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sb.deleteCharAt(i);
            if(isPalindrome(sb)) return true;
            sb.insert(i,c);
        }
        return isPalindrome(s);
    }

    private boolean isPalindrome(CharSequence s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Approach - 2 :
     */
    public boolean validPalindrome2(String s) {
        int l = 0, r = s.length()-1, skip = 1;
        return isPalindrome(s,0,s.length()-1,skip);
    }

    private boolean isPalindrome(String s, int l , int r, int skip){
        if(l > r) return true;
        if(s.charAt(l) == s.charAt(r)){
            return isPalindrome(s,l+1,r-1,skip);
        }else if(skip == 1){
            return isPalindrome(s,l+1,r,0) || isPalindrome(s,l,r-1,0);
        }else
            return false;
    }

    /**
     * Approach - 3 : Greedy
     * TC: O(N), SC: O(1)
     * @param s
     * @param i
     * @param j
     * @return
     */
    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public boolean validPalindrome3(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }
}
