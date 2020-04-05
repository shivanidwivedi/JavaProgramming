package leetcode.Strings;

/**
 * @author shivanidwivedi on 11/02/20
 * @project JavaProgramming
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 */
public class SplitBalancedStrings {

    //Fastest
    public static int balancedStringSplit(String s) {
        int count1 = 0, count2 = 0, count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'L'){
                count1++;
            } else{
                count2++;
            }
            if(count1 == count2){
                count++;
                count1 =0;
                count2 = 0;
            }
        }
        return count;
    }
}
