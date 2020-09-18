package leetcode;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author shivanidwivedi on 17/09/20
 * @project JavaProgramming
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 *
 * TC: O(n)- best, O(nk)- worst, SC: O(k)
 */
public class LongestSubstringWithKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.isEmpty() || k == 0){
            return 0;
        }
        int left = 0, right = 0;
        int maxLength = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            map.put(s.charAt(right), right);
            right++;
            if(map.size() == k+1){
                int deleteIndex = Collections.min(map.values());
                map.remove(s.charAt(deleteIndex));
                left = deleteIndex+1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] s){
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
