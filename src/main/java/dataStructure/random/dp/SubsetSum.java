package dataStructure.random.dp;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 16/02/21
 * @project JavaProgramming
 */
public class SubsetSum {
    //Bottom up approach
    public boolean canPartition(int[] num, int sum) {
        int n = num.length;

        boolean[][] dp = new boolean[n][sum+1];

        // populate the sum=0 column, as we can always have '0' sum without including any element
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        // with only one number, we can form a subset only when the required sum is equal to its value
        for(int s = 1; s <= sum; s++){
            dp[0][s] = (num[0] == s) ? true : false;
        }
        // process all subsets for all sums
        for(int i = 1; i < n; i++){
            for(int s = 1; s <= sum; s++){
                // if we can get the sum 'sum' without the number at index 'i'
                if(dp[i-1][s]){
                    dp[i][s] = dp[i-1][s];
                }else if(s >= num[i]){ // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i-1][s - num[i]];
                }
            }
        }

        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        SubsetSum obj = new SubsetSum();
        Assert.assertTrue(obj.canPartition(new int[]{1,2,3,7},6));
        Assert.assertTrue(obj.canPartition(new int[]{1,2,7,1,5},10));
        Assert.assertFalse(obj.canPartition(new int[]{1,3,4,8},6));
    }
}
