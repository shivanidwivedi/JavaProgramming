package leetcode.Strings;

/**
 * @author shivanidwivedi on 21/10/20
 * @project JavaProgramming
 * KMP algorithm, TC: O(m+n), SC: O(n), m is the text length and n is the pattern length
 */
public class SubstringSearchKMP {
    public boolean hasSubstring(String text, String pattern){
        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int[] prefixSuffixArray = longestPrefixSuffixArray(pattern);
        int i = 0, j = 0;
        while (i < textArray.length && j < patternArray.length){
            if(textArray[i] == patternArray[j]){
                i++;
                j++;
            }else {
                if(j != 0){
                    j = prefixSuffixArray[j-1];
                }else {
                    i++;
                }
            }
        }
        if(j == patternArray.length){
            return true;
        }
        return false;
    }
    //Compute temporary array to maintain size of suffix which is same as prefix
    public int[] longestPrefixSuffixArray(String pattern){
        int[] array = new int[pattern.length()];
        char[] patternArray = pattern.toCharArray();
        int index = 0;
        for (int i = 1; i < patternArray.length;){
            if(patternArray[i] == patternArray[index]){
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
        SubstringSearchKMP substringSearchKMP = new SubstringSearchKMP();
        System.out.println(substringSearchKMP.hasSubstring("abcxabcdabcdabcy", "abcdabcy"));
        System.out.println(substringSearchKMP.hasSubstring("abcxabcdabcdabcy", "abcdabcyx"));
        System.out.println(substringSearchKMP.hasSubstring("ab", "ab"));
    }
}

