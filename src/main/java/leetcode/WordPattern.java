package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shivanidwivedi on 07/09/20
 * @project JavaProgramming
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {

        HashMap<Character, String> map = new HashMap<>();
        String[] array = str.split(" ");
        HashSet<String> set = new HashSet<>();
        if (pattern.length() != array.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (set.contains(array[i])) {
                    return false;
                }
                map.put(ch, array[i]);
                set.add(array[i]);
            } else {
                String current = map.get(ch);
                if (!current.equals(array[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] s) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
