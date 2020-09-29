package ctcibook.arraystring;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 *
 * Given two strings, write a method to decide if one is a permutation of the other.
 * Consider it is case sensitive and whitespaces are significant. We will assume for this problem that the comparison is case sensitive and whitespace is
 * significant. So, "god    " is different from "dog"
 */


public class CheckStringPermutation {
    //Approach-1 : Sort the strings, not so optimal but good in practical sense
    public static boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private static String sort(String string){
        char[] content = string.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void main(String[] s){
        System.out.println(permutation("     god", "god"));
        System.out.println(permutation("god", "god"));
        System.out.println(permutation("God", "god"));
        System.out.println(permutation("god", "dog"));
        System.out.println(permutationCount("     god", "god"));
        System.out.println(permutationCount("god", "god"));
        System.out.println(permutationCount("God", "god"));
        System.out.println(permutationCount("god", "dog"));
    }

    //Approach-2 : Check if the two strings have identical character counts.
    public static boolean permutationCount(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] letters = new int[256];
        for (char ch : s.toCharArray()){
            letters[ch]++;
        }
        for (int i = 0; i < t.length(); i++){
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }

}
