package leetcode;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 29/06/20
 * @project JavaProgramming
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * TC: O(N), SC: O(N)
 */
public class DecodeWays {
//Recursive with memoization - DP

    public static int numDecodings(String s) {
        if (s.length() == 0 || s == null) return 0;
        return recursiveWithMemo(0, s);
    }

    private static int recursiveWithMemo(int index, String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (index == s.length()) return 1;

        if (s.charAt(index) == '0') return 0;
        if (index == s.length() - 1) return 1;

        if (map.containsKey(index)) {
            return map.get(index);
        }
        int ans = recursiveWithMemo(index + 1, s);

        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, s);
        }
        map.put(index, ans);
        return ans;
    }
}