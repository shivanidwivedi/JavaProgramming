package hackerrank;

/**
 * @author shivanidwivedi on 13/07/20
 * @project JavaProgramming
 */
public class MakingAnagrams {
    public static int makeAnagram(String a, String b) {
        if(a.length() == 0) return b.length();
        if(b.length() == 0) return a.length();
        int minimum = 0;
        int[] count = new int[26];
        for(int i = 0; i < a.length(); i++){
            count[a.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < b.length(); i++){
            count[b.charAt(i) - 'a'] -= 1;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                minimum += Math.abs(count[i]);
            }
        }
        return minimum;
    }
}
