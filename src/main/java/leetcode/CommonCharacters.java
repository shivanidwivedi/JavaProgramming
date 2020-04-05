package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonCharacters {

    /**
     * MAIN function
     * @param words
     * @return
     */
    public static List<String> commonCharsByAscii(String[] words) {
        if(words.length > 1) {
            int[] arr = wordToAscii(words[0]);
            for(int i = 1; i < words.length; i++) {
                arr =  commonAsciiArray(arr, wordToAscii(words[i]));
            }
            return arrayToList(arr);
        }
        else{
            return null;
        }
    }

    /**
     *
     * @param arr
     * @return
     */
    static List<String> arrayToList(int[] arr){
        List<String> common = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                while(arr[i]-- > 0) {
                    char c = (char) (i+97);
                    common.add(c + "");
                }
            }
        }
        return common;
    }

    /**
     * Returns least common values between two arrays
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] commonAsciiArray(int[] arr1, int[] arr2) {
        int[] arr = new int[26];
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != 0 && arr2[i] != 0){
                arr[i] = Math.min(arr1[i], arr2[i]);
            }
        }
        return arr;
    }

    static int[] wordToAscii(String word) {
        int[] arr = new int[26];
        for(int i = 0; i < word.length(); i++) {
            arr[word.charAt(i)-97]++;
        }
        return arr;
    }
}
