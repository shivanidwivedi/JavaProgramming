package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 24/08/20
 * @project JavaProgramming
 *
 * Example 1:
 *
 * Input
 * ["ValidWordAbbr","isUnique","isUnique","isUnique","isUnique"]
 * [[["deer","door","cake","card"]],["dear"],["cart"],["cane"],["make"]]
 * Output
 * [null,false,true,false,true]
 *
 * Explanation
 * ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
 * validWordAbbr.isUnique("dear"); // return False
 * validWordAbbr.isUnique("cart"); // return True
 * validWordAbbr.isUnique("cane"); // return False
 * validWordAbbr.isUnique("make"); // return True
 */
public class ValidWordAbbreviation {
    static HashMap<String, Set<String>> map = new HashMap<>();

    public ValidWordAbbreviation(String[] dictionary) {
        for(String s : dictionary){
            String abbr = getAbbr(s);
            Set<String> words = map.containsKey(abbr) ? map.get(abbr) : new HashSet<>();
            words.add(s);
            map.put(abbr,words);
        }
    }

    public static boolean isUnique(String word) {
        String abbr = getAbbr(word);
        Set<String> words = map.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }

    private static String getAbbr(String word){
        if(word.length() <= 2){
            return word;
        }
        return word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1);
    }

    public static void main(String[] s){
        ValidWordAbbreviation validWordAbbreviation = new ValidWordAbbreviation(new String[]{"deer", "door", "cake", "card"});
        System.out.println(ValidWordAbbreviation.isUnique("dear"));
        System.out.println(ValidWordAbbreviation.isUnique("cart"));
        System.out.println(ValidWordAbbreviation.isUnique("cane"));
        System.out.println(ValidWordAbbreviation.isUnique("make"));
    }
}
