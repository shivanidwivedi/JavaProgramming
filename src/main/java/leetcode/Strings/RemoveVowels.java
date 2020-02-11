package leetcode.Strings;

/**
 * @author shivanidwivedi on 10/02/20
 * @project JavaProgramming
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 */

public class RemoveVowels {

    //Method-1:
    public static String removeVowels(String S) {
       return S.replaceAll("[aeiou]", "");
    }

    //Method-2: Using String buffer
    public static String removeVowelsSB(String S) {
        StringBuffer sb = new StringBuffer(S.length());
        for (int i = 0; i < S.length(); i++){
            if (!isVowel(S.charAt(i))){
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public static boolean isVowel(char c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }else {
            return false;
        }
    }
}

