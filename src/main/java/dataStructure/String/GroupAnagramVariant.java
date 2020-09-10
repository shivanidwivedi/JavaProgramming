package dataStructure.String;

import java.util.*;

/**
 * @author shivanidwivedi on 10/09/20
 * @project JavaProgramming
 */
public class GroupAnagramVariant {
    public static List<List<String>> group(String[] words){
        List<List<String>> result = new ArrayList<>();
        if(words.length == 0 || words == null){
            return result;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String string : words){
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < string.length(); i++){
                set.add(Character.toLowerCase(string.charAt(i)));
            }
            Arrays.sort(set.toArray());
            String key = String.valueOf(set);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

    public static void main (String[] args) {
        System.out.println(group(new String[]{"Good", "pan", "nap", "dog", "god"}));
    }

}
