package leetcode.Strings;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    //Method-2:
    public static String toLowerCase2(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90){
                sb.setCharAt(i, (char) (str.charAt(i) + 32));
            }
        }
        return sb.toString();
    }
}
