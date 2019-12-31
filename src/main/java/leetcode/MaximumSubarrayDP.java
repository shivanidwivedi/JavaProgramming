package leetcode;

public class MaximumSubarrayDP {
        public static int maxSubArray(int[] nums) {
            int n = nums.length, maxSum = nums[0];
            if (n==0) return -1;
            for(int i = 1; i < n; ++i) {
                if (nums[i - 1] > 0) nums[i] += nums[i - 1];
                maxSum = Math.max(nums[i], maxSum);
            }
            return maxSum;
        }
}
