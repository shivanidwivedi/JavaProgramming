package leetcode;

/**
 * @author shivanidwivedi on 20/01/20
 * @project JavaProgramming
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int order = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = 0;
                nums[order] = temp;
                order++;
            }
        }
        return nums;
    }
}
