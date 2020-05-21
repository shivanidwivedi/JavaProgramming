package leetcode.Strings;

/**
 * @author shivanidwivedi on 21/05/20
 * @project JavaProgramming
 * Given an input string , reverse the string word by word.
 * Time complexity: O(N), it's two passes along the string.
 */
public class ReverseWords2 {
    public static void reverseWords(char[] s) {
        swap(s, 0, s.length-1);
        reverseWord(s);
    }

    private static void swap(char[] s, int left, int right){
        while(left <= right){
            char temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }

    private static void reverseWord(char[] s){
        int n = s.length;
        int start = 0, end = 0;
        while(start < n){
            while(end < n && s[end] != ' '){
                end++;
            }
            swap(s,start,end-1);
            start = end+1;
            end++;
        }
    }
}
