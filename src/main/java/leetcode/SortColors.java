package leetcode;

/**
 * @author shivanidwivedi on 21/05/20
 * @project JavaProgramming
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int current = 0, p0 = 0, p2 = nums.length - 1;
        int temp;
        while(current <= p2){
            if(nums[current] == 0){
                temp = nums[p0];
                nums[p0] = nums[current];
                nums[current] = temp;
                p0++;
                current++;
            } else if(nums[current] == 2){
                temp = nums[current];
                nums[current] = nums[p2];
                nums[p2] = temp;
                p2--;
            }else current++;
        }
    }
}
