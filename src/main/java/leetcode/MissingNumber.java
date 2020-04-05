package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 22/01/20
 * @project JavaProgramming
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i-1] != 1){
                return i;
            }
        }
        return -1;
    }

    public static int missingNumberSinglePass(int[] nums) {
        int sum = (nums.length) * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int i: nums) {
            actualSum += i;
        }
        return sum - actualSum;
    }
}
