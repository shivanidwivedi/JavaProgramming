package leetcode;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 22/02/21
 * @project JavaProgramming
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0, right = 0, maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxLen = Math.max(maxLen, 2 * right);
            }else if(right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();
        Assert.assertEquals(4, obj.longestValidParentheses(")()())"));
        Assert.assertEquals(2, obj.longestValidParentheses("(()"));
    }
}
