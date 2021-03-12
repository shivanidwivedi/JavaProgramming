package leetcode;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 01/03/21
 * @project JavaProgramming
 */
public class MaxSumNonOverlapArrays {
    public int[] maxSum(int[] nums, int k){
        int N = nums.length;
        int[][] dp = new int[N][4];
        int[] presum = new int[N];
        init(presum, nums);

        for(int j = 1; j <= 3; j++){
            int max = 0;
            for(int i = 0; i < N; i++){
                if(i < j * k - 1) {
                    dp[i][j] = 0;
                } else if(i == j * (k - 1)) {
                    max = presum[i];
                    dp[i][j] = max;
                }else{
                    max = Math.max(max, presum[i] - presum[i - k] + dp[i - k][j - 1]);
                    dp[i][j] = max;
                }
            }
        }

        int[] ans = new int[3];
        getAns(ans, dp, k);
        return ans;
    }

    private void getAns(int[] ans, int[][] dp, int k){
        int arrays = 3;
        int idx = 2;
        int end = dp.length - 1;

        while(arrays > 0 && end > 0){
            if(dp[end][arrays] != dp[end - 1][arrays]){
                ans[idx--] = end - k + 1;
                end = end - k;
                arrays--;
                continue;
            }
            end--;
        }
    }

    private void init(int[] presum, int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i] = sum;
        }
    }


    public static void main(String[] args) {
        MaxSumNonOverlapArrays obj = new MaxSumNonOverlapArrays();
        Assert.assertEquals(Arrays.toString(new int[]{0,3,5}),
                Arrays.toString(obj.maxSum(new int[]{1,2,1,2,6,7,5,1}, 2)));
    }
}
