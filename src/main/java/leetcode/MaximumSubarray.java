package leetcode;
//import java.util.Arrays;

public class MaximumSubarray {
        public static int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n==0) return -1;
            int currSum = nums[0], maxSum = nums[0];

            for(int i = 1; i < n; ++i) {
                currSum = Math.max(nums[i], currSum + nums[i]);
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }
}
