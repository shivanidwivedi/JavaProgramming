package dataStructure.random.dp;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 16/02/21
 * @project JavaProgramming
 *
 * Given a set of positive numbers, find if we can partition it into two subsets
 * such that the sum of elements in both the subsets is equal.
 *
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 *
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 *
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 *
 * The above solution has time and space complexity of O(N*S),
 * where ‘N’ represents total numbers and ‘S’ is the total sum of all the numbers.
 */
public class EqualSubsetSumPartition {
    //Bottom up approach
    public boolean canPartition(int[] num) {
        int totalSum = getSum(num);
        int n = num.length;
        // if 'totalSum' is a an odd number, we can't have two subsets with same total
        if(totalSum % 2 != 0){
            return false;
        }
        totalSum /= 2;

        boolean[][] dp = new boolean[n][totalSum+1];

        // populate the sum=0 column, as we can always have '0' sum without including any element
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        // with only one number, we can form a subset only when the required sum is equal to its value
        for(int sum = 1; sum <= totalSum; sum++){
            dp[0][sum] = (num[0] == sum) ? true : false;
        }
        // process all subsets for all sums
        for(int i = 1; i < n; i++){
            for(int sum = 1; sum <= totalSum; sum++){
                // if we can get the sum 'sum' without the number at index 'i'
                if(dp[i-1][sum]){
                    dp[i][sum] = dp[i-1][sum];
                }else if(sum >= num[i]){ // else if we can find a subset to get the remaining sum
                    dp[i][sum] = dp[i-1][sum - num[i]];
                }
            }
        }

        return dp[n-1][totalSum];
    }

    private int getSum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        EqualSubsetSumPartition obj = new EqualSubsetSumPartition();
        Assert.assertTrue(obj.canPartition(new int[]{1,2,3,4}));
        Assert.assertTrue(obj.canPartition(new int[]{1,1,3,4,7}));
        Assert.assertFalse(obj.canPartition(new int[]{2,3,4,6}));
        Assert.assertFalse(obj.canPartition(new int[]{1,2,5}));
    }
}
