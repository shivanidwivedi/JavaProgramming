package leetcode.Strings;

/**
 * @author shivanidwivedi on 25/04/20
 * @project JavaProgramming
 */
public class MaxScore {
    public static int maxScore(String s) {
        int countZeroLeft = 0, countOneRight = 0;
        int splitIndex = 0, checkIndex =0;
        int maxSum = 0;
        String extra = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                countZeroLeft++;
            }else if (countZeroLeft > 0){
                    splitIndex = i;
                    checkIndex = i;
                    extra = s.substring(i);
                    break;
            } else if(countZeroLeft == 0 && s.charAt(i) == '1'){
                extra = s.substring(i+1);
                break;
            }
        }
        for(int i = checkIndex; i < s.length(); i++){

        }
        for(int i = 0; i < extra.length(); i++){
            if(extra.charAt(i) == '1'){
                countOneRight++;
            }
        }
        maxSum = countZeroLeft + countOneRight;
        return maxSum;
    }
}
