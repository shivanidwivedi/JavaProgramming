package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 */
public class CountCharacters {

    public static int countCharactersByHashmap(String[] words, String chars) {

        Map<Character, Integer> charsMap = wordToHashmap(chars);
        int count = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = wordToHashmap(word);
            if (isContainingWord(charsMap, wordMap)) {
                count += word.length();
            }
        }

        return count;
    }
    /**
     * Returns char - frequency mapping
     * @param word
     * @return
     */
    static Map<Character, Integer> wordToHashmap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.replace(ch, map.get(ch) + 1);
            }
        }
        return map;
    }

    /**
     *
     * @param charsMap
     * @param wordMap
     * @return
     */
    static boolean isContainingWord(Map<Character, Integer> charsMap, Map<Character, Integer> wordMap) {
       int count = 0;
        for(Character key :wordMap.keySet()){
            if (!charsMap.containsKey(key) || (charsMap.get(key) < wordMap.get(key))){
                return false;
            }
        }
        return true;
    }

    public static int countCharacters(String words[], String chars){
        int count = 0;
        int[] asciiArray = asciiArray(chars); //CLASSIC MISTAKE OF ARRAY BY REFERENCE
        for (String word : words) {
            int[] copyArr = Arrays.copyOf(asciiArray, asciiArray.length); // To avoid any modification to original array
            if(isContainingWord(word, copyArr)) {
                count += word.length();
            }
        }
        return count;
    }

    /**
     *
     * @param word
     * @param asciiArray
     * @return
     */
    static boolean isContainingWord(String word, int[] asciiArray) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i);
            asciiArray[index] = asciiArray[index] - 1;
            if(asciiArray[index] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * constructing ascii array from word
     * @param chars
     * @return
     */
    static int[] asciiArray(String chars) {
        int[] arr = new int[256];
        for(int i = 0; i < chars.length(); i++) {
            arr[chars.charAt(i)]++;
        }
        return arr;
    }
}
