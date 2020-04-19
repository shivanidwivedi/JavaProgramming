package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 18/04/20
 * @project JavaProgramming
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 *
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
 *
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 * Example 3:
 *
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 * Example 4:
 *
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 * Example 5:
 *
 * Input: s = "ab123"
 * Output: "1a2b3"
 */
public class ReformatTheString {
    public static String reformat(String s) {
        String letter = s.replaceAll("\\d", "");
        String digit = s.replaceAll("\\D", "");
        if(Math.abs(letter.length() - digit.length()) >1) {
            return "";
        }
        String output = "";
        int letterIndex = 0 , digitIndex = 0;

        //initialize first character
       output += (letter.length() > digit.length()) ? letter.charAt(0) : digit.charAt(0);
        if (Character.isLetter(output.charAt(0))){
            letterIndex++;
        }else {
            digitIndex++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (Character.isLetter(output.charAt(i-1))){
                output += digit.charAt(digitIndex++);
            }else output += letter.charAt(letterIndex++);
        }
       return output;
    }
}
