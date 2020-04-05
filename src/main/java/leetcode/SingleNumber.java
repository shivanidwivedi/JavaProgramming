package leetcode;

/**
 * @author shivanidwivedi on 01/04/20
 * @project JavaProgramming
 */
public class SingleNumber {
    public static int singleNumber(int[] nums){
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
