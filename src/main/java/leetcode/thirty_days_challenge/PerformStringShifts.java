package leetcode.thirty_days_challenge;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 14/04/20
 * @project JavaProgramming
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 */

public class PerformStringShifts {
    public static String stringShift(String s, int[][] shift) {
        int []simplifiedShift = simplifyShifts(shift);
        if(simplifiedShift == null) {
            return s;
        }
        int startIndex = getStartIndex(s,simplifiedShift);
        String output = shiftedWord(s,startIndex);
        return output;
    }
    static int[] simplifyShifts(int[][] shift){
        int []arr = new int[2];
        int left= 0, right = 0; //0: left, 1: right
        for (int i = 0; i < shift.length; i++){
            if(shift[i][0] == 0) {
                left += shift[i][1];
            } else {
                right += shift[i][1];
            }
        }
        int totalShifts = Math.abs(left - right);
        if(totalShifts == 0) {
            return null;
        }
        arr[1] = totalShifts;
        arr[0] = (left > right) ? 0 : 1;
        return arr;
    }

    /**
     * example: abcde: [0,3]--> deabc = 3, [1,3]--> cdeab = 2
     * abcdefgh: [0,2]--> cdefghab = 2, [1,2]--> ghabcdef =
     * @param s
     * @param shift
     * @return
     */
    static int getStartIndex(String s, int shift[]){
        if (shift[0] == 0){
            return shift[1] % s.length();
        }else {
            return (s.length() - (shift[1] % s.length())) % s.length();
        }
    }
    static String shiftedWord(String s, int startIndex){
        String output = s.substring(startIndex)+s.substring(0,startIndex);
        return output;
    }

}
