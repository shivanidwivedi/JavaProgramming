package leetcode.Strings;

/**
 * @author shivanidwivedi on 16/02/20
 * @project JavaProgramming
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * LC-557
 */
public class ReverseWords {
    //optimized solution
    public static String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String str: words){
            sb.append(new StringBuilder(str).reverse().toString());
            i++;
            if(i!=words.length){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static String reverseWords_2(String s) {
        String[] words = s.split(" ");
        String reverse = "";

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            reverse = reverse + sb + " ";
        }
        return reverse.substring(0, reverse.length() - 1);
    }
}
