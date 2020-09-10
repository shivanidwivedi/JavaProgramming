package leetcode;

/**
 * @author shivanidwivedi on 10/09/20
 * @project JavaProgramming
 *
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 * Example 1:
 *
 * Input:
 * ["a","a","b","b","c","c","c"]
 *
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 *
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 */
public class StringCompression {
    public static int compress(char[] chars) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < chars.length; i++){
            if (chars[i] != chars[i-1]){
                sb.append(chars[i-1]);
                if(count > 1){
                    sb.append(count);
                    count = 1;
                }
            }else count++;
        }
        sb.append(chars[chars.length - 1]);
        if (count > 1)
            sb.append(count);
        if (sb.length() > chars.length)
            return chars.length;
        for (int i = 0; i < sb.length(); i++)
            chars[i] = sb.charAt(i);
        return sb.length();
    }

    public static void main(String[] s){
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
