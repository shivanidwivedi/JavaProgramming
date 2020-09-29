package ctcibook.arraystring;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Implement an algorithm to determine if a string has all unique characters. What if
 * you cannot use additional data structures?
 */

// Considering the ASCII and not the unicode, total 256 possible characters in ASCII
    //TC : O(n), SC : O(1)
public class UniqueCharactersString {
    public static boolean isUniqueChars2(String str){
        if (str.length() > 256) return false;
        boolean[] flagset = new boolean[256];
        for (char ch : str.toCharArray()){
            if(flagset[ch]){
                return false;
            }
            flagset[ch] = true;
        }
        return true;
    }

    public static void main(String[] s){
        System.out.println(isUniqueChars2("jhdau"));
        System.out.println(isUniqueChars2("37shfck"));
        System.out.println(isUniqueChars2("2w2w"));
    }
}
