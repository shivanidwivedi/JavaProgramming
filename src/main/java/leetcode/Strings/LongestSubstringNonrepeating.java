package leetcode.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 12/03/20
 * @project JavaProgramming
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringNonrepeating {
    //Method-1
    public static int lengthOfLongestSubstringBrute(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j <=s.length(); j++){
                if (isUnique(s,i,j)){
                    ans = Math.max(ans, j-i);
                }
            }
        }
        return ans;
    }
    public static boolean isUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            if (set.contains(c)){
                return false;
            }else {
                set.add(c);
            }
        }
        return true;
    }

    //Method-2: Sliding window
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
