package leetcode_contest;

import java.util.Stack;

/**
 * @author shivanidwivedi on 08/08/20
 * @project JavaProgramming
 */
public class ModifyString {
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : s.toCharArray()) {
            if (sbLength != 0 && isValid(character, sb.charAt(sbLength-1)))
            sb.deleteCharAt(sbLength-- - 1);
      else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] s){
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("s"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood(""));
    }

    public static boolean isValid(char ch, char ch1){
        return Math.abs(ch-ch1) == 32;
    }
}
