package leetcode;

/**
 * @author shivanidwivedi on 21/01/20
 * @project JavaProgramming
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max =0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                count++;
                max = Math.max(max, count);
            }else {
                count = 0;
            }
        }
        return max;
    }
}
