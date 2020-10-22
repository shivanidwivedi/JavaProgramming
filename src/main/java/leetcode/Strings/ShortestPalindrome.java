package leetcode.Strings;

/**
 * @author shivanidwivedi on 21/10/20
 * @project JavaProgramming
 *
 * Given a string s, you can convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: "dcbabcd"
 */

//Using KMP algorithm, TC: O(n), SC: O(n)
public class ShortestPalindrome {
    public String shortestPalindrome(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = new StringBuilder(s).reverse();
        stringBuilder.append('#').append(reverse);
        int[] prefixSuffixArray = computePrefixSuffixArray(stringBuilder.toString());
        return new StringBuilder(s.substring(prefixSuffixArray[prefixSuffixArray.length - 1])).reverse().toString() + s;
    }

    public int[] computePrefixSuffixArray(String s){
        char[] stringArray = s.toCharArray();
        int[] array = new int[s.length()];
        int index = 0;
        for (int i = 1; i < stringArray.length;){
            if(stringArray[index] == stringArray[i]){
                array[i] = index + 1;
                index++;
                i++;
            }else {
                if(index != 0){
                    index = array[index - 1];
                }else {
                    array[i] = 0;
                    i++;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        System.out.println(shortestPalindrome.shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome.shortestPalindrome("abcd"));
    }
}
