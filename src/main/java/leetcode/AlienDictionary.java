package leetcode;

import org.junit.Assert;

import java.util.*;

/**
 * @author shivanidwivedi on 17/02/21
 * @project JavaProgramming
 *
 * There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.
 * You are given a list of strings words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language, and return it. If the given input is invalid, return "".
 * If there are multiple valid solutions, return any of them.
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */
public class AlienDictionary {
    Map<Character, List<Character>> adjacent = new HashMap<>();
    Map<Character, Integer> count = new HashMap<>();

    public String alienOrder(String[] words) {
        getCount(words);
        //find all edges
        for(int i = 0; i < words.length - 1; i++){
            String firstWord = words[i];
            String secondWord = words[i+1];
            if(firstWord.length() > secondWord.length() && firstWord.startsWith(secondWord)){
                return "";
            }
            for (int j = 0; j < Math.min(firstWord.length(), secondWord.length()); j++) {
                if (firstWord.charAt(j) != secondWord.charAt(j)) {
                    adjacent.get(firstWord.charAt(j)).add(secondWord.charAt(j));
                    count.put(secondWord.charAt(j), count.get(secondWord.charAt(j)) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : count.keySet()) {
            if (count.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjacent.get(c)) {
                count.put(next, count.get(next) - 1);
                if (count.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        if (sb.length() < count.size()) {
            return "";
        }
        return sb.toString();
    }

    private void getCount(String[] words){
        for(String word : words){
            for(char ch : word.toCharArray()){
                count.put(ch, 0);
                adjacent.put(ch, new ArrayList<>());
            }
        }
    }

    public static void main(String[] args) {
        AlienDictionary dictionary = new AlienDictionary();
        Assert.assertEquals("wertf",dictionary.alienOrder
                (new String[] {"wrt","wrf","er","ett","rftt"}));
    }
}
