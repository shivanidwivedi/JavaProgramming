package leetcode.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author shivanidwivedi on 06/04/20
 * @project JavaProgramming
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 *
 */
public class GroupAnagram {
    //Using HashMap

    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return new ArrayList();
        }
        HashMap<String,List> map = createMap(strs);
        return new ArrayList(map.values());
    }

    /**
     *
     * @param strs
     * @return
     */
    private static HashMap<String,List> createMap(String[] strs){
        HashMap<String, List> map = new HashMap<>();
        for (String s: strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return map;
    }
}

