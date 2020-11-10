package leetcode.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shivanidwivedi on 10/11/20
 * @project JavaProgramming
 *
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return the empty string "".
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Time Complexity: O(|S| + |T|), Space complexity : O(∣S∣ + ∣T∣)
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int required = map.size();
        int left = 0, right = 0;
        int visited = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        int[] result = {-1, 0, 0};
        while(right < s.length()){
            char ch = s.charAt(right);
            windowCount.put(ch, windowCount.getOrDefault(ch, 0) + 1);
            if(map.containsKey(ch) && windowCount.get(ch).intValue() == map.get(ch).intValue()){
                visited++;
            }
            while(left <= right && visited == required){
                ch = s.charAt(left);
                if(result[0] == -1 || right - left + 1 < result[0]){
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }
                windowCount.put(ch, windowCount.get(ch) - 1);
                if(map.containsKey(ch) && windowCount.get(ch).intValue() < map.get(ch).intValue()){
                    visited--;
                }
                left++;
            }
            right++;
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2]+1);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(MinimumWindowSubstring.minWindow("a", "a"));
        System.out.println(MinimumWindowSubstring.minWindow("", "a"));
    }
}
