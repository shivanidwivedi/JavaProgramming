package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shivanidwivedi on 23/08/20
 * @project JavaProgramming
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }

        HashSet<Character> set = new HashSet<>(map.values());
        if(set.size() != map.size()){
            return false;
        }
        return true;
    }

    public static void main(String[] s){
        System.out.println(isIsomorphic("foo", "egg"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("foo", "bar"));
    }
}
