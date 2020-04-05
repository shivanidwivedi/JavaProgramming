package leetcode.Strings;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 * There is a special keyboard with all keys in a single row.
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25),
 * initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character.
 * The time taken to move your finger from index i to index j is |i - j|.
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 */

public class SingleRowKeyboard {

    public static int calculateTime(String keyboard, String word) {
        int time = 0, index = 0;
        for (char c:
             word.toCharArray()) {
            int current = keyboard.indexOf(c);
            time += Math.abs(current-index);
            index = current;
        }
        return time;
    }

    //Using HashMap (slower)
    public static int calculateTime2(String keyboard, String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++){
            map.put(keyboard.charAt(i),i);
        }
        int time = 0, index = 0;
        for (char c:
                word.toCharArray()) {
            time += Math.abs(map.get(c) - index);
            index = map.get(c);
        }
        return time;
    }
}
