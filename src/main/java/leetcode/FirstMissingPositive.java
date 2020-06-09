package leetcode;

import java.util.HashSet;

/**
 * @author shivanidwivedi on 09/06/20
 * @project JavaProgramming
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive {
    // HashSet
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositiveContantSpace(int[] nums) {
        int n = nums.length;
        if(nums == null || nums.length == 0) return 1;
        boolean isOne = false;
        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                isOne = true;
            }
            if(nums[i] > n || nums[i] < 1){
                nums[i] = 1;
            }
        }
        if(!isOne) return 1;
        //Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for(int i = 0; i < nums.length; i++){
            int a = Math.abs(nums[i]);
            if(a == n){
                nums[0] = -Math.abs(nums[0]);
            }else{
                nums[a] = -Math.abs(nums[a]);
            }
        }
        // Now the index of the first positive number
        // is equal to first missing positive.
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        if(nums[0] > 0){
            return nums.length;
        }
        return nums.length + 1;
    }
}
