package leetcode;

/**
 * @author shivanidwivedi on 16/06/20
 * @project JavaProgramming
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
    Time complexity : O(n)
    Space complexity : O(1)
 */
public class MinimumSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum >= s){
                minLength = Math.min(minLength, i+1-left);
                sum -= nums[left];
                left++;
            }
        }
        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }
}
