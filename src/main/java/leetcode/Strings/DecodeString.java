package leetcode.Strings;

import java.util.Stack;

/**
 * @author shivanidwivedi on 21/07/20
 * @project JavaProgramming
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
public class DecodeString {
    public static String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<Integer> intStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        String result = "";
        int index = 0;
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                intStack.push(count);
            }else if(s.charAt(index) == '['){
                charStack.push(result);
                result= "";
                index++;
            }else if(s.charAt(index) == ']'){
                StringBuilder temp = new StringBuilder(charStack.pop());
                int count = intStack.pop();
                for(int i = 0; i < count; i++){
                    temp.append(result);
                }
                result = temp.toString();
                index++;
            }else{
                result += s.charAt(index);
                index++;
            }
        }

        return result;
    }
}
