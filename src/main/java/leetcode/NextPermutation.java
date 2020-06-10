package leetcode;

/**
 * @author shivanidwivedi on 10/06/20
 * @project JavaProgramming
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples.
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Time complexity : O(n). In worst case, only two scans of the whole array are needed.
 * Space complexity : O(1). No extra space is used. In place replacements are done.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while(index >= 0 && nums[index] >= nums[index+1]){
            index--;
        }
        if(index >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[index]){
                j--;
            }
            swap(nums,index,j);
        }
        reverse(nums,index + 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
