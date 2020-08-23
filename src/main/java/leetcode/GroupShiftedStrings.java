package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shivanidwivedi on 23/08/20
 * @project JavaProgramming
 *
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * Example:
 *
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 */
public class GroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        if(strings == null || strings.length == 0){
            return new ArrayList();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            String key = getKey(s);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    private static String getKey(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < str.length(); i++){
            sb.append(getDiff(str.charAt(i-1), str.charAt(i)));
            sb.append("#");
        }
        return sb.toString();
    }

    private static int getDiff(char aChar, char bChar){
        int aVal = aChar - 'a';
        int bVal = bChar - 'a';
        if(bVal >= aVal){
            return bVal - aVal;
        }else{
            return (bVal + 26) - aVal;
        }
    }

    public static void main(String[] s){
        System.out.println(groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}
