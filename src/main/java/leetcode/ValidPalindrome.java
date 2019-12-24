package leetcode;
import java.lang.String;

/**
 * ASCII: 97-122, capitals: 65-90 and 0-9
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s==null) return true;
        s = s.toLowerCase();
        //remove unwanted characters such as special char, white speces
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        //System.out.println(new Integer('A'));
        int i = 0, j= s.length()-1;
        while (i<j && s.charAt(i)==s.charAt(j)){
            i++; j--;
        }
        if(i>=j)
            return true;

        return false;
    }


}
