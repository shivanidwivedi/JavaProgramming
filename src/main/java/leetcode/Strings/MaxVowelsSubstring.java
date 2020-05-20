package leetcode.Strings;

/**
 * @author shivanidwivedi on 24/04/20
 * @project JavaProgramming
 */
public class MaxVowelsSubstring {
    public static String maxVowels(String string, int k){
        if (string.length() < k){
            return "";
        }
        String result = "";
        int maxVowels = 0, first = 0, second = k - 1;
        int index1 = 0, index2 = k;
      while(first < string.length() && second < string.length()){
          int currVowels = 0;
          for(int i = first; i <= second ; i++){
              if (isVowel(string.charAt(i))){
                  currVowels++;
              }
          }

          if (currVowels > maxVowels){

              result =  string.substring(first,second + 1);
          }

          maxVowels = Math.max(maxVowels,currVowels);
          first++;
          second++;
      }
        return result;
    }

    private static boolean isVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}
