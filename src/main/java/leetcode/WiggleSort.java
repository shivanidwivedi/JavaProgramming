package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 26/10/20
 * @project JavaProgramming
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * Example:
 *
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 */
public class WiggleSort {
//TC: O(n log n), SC: O(1)
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
        System.out.println(Arrays.toString(nums));
    }
    //TC: O(n), SC: O(1)
    public void wiggleSortOnePass(int[] nums) {
        if(nums.length == 0 || nums == null){
            return;
        }
        boolean less = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(less){
                if(nums[i] > nums[i+1]){
                    swap(nums, i, i+1);
                }
            }else{
                if(nums[i] < nums[i+1]){
                    swap(nums, i, i+1);
                }
            }
            less = !less;
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        WiggleSort wiggle = new WiggleSort();
        wiggle.wiggleSort(new int[]{3,5,2,1,6,4});
        wiggle.wiggleSortOnePass(new int[]{3,5,2,1,6,4});
    }
}
