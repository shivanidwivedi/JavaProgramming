package leetcode.Strings;

/**
 * @author shivanidwivedi on 21/05/20
 * @project JavaProgramming
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 * Time Complexity: O(N^2), where N is the length of S. This represents the complexity of rotating the word and adding extra "a" characters.
 *
 * Space Complexity: O(N^2), the space added to the answer by adding extra "a" characters.
 */
public class GoatLatin {
    public static String toGoatLatin(String S) {
        if(S.length() == 0 || S == null) return "";
        StringBuilder sb = new StringBuilder();
        int count = 0, index = 0;
        String[] array = S.split(" ");
        for(String s : array){
            index++;
            if(isVowel(s.charAt(0))){
                sb.append(s);
            }else{
                sb.append(s.substring(1)+s.charAt(0));
            }
            sb.append("ma");
            count = index;
            while(count > 0){
                sb.append("a");
                count--;
            }
            if(index != array.length){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }
}
