package dataStructure.random;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 16/02/21
 * @project JavaProgramming
 *
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack that has a capacity ‘C’.
 * The goal is to get the maximum profit from the items in the knapsack.
 * Each item can only be selected once, as we don’t have multiple quantities of any item.
 *
 * Example:
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 *
 * Solution Explanation
 *
 * Apple + Orange (total weight 5) => 9 profit
 * Apple + Banana (total weight 3) => 7 profit
 * Orange + Banana (total weight 4) => 8 profit
 * Banana + Melon (total weight 5) => 10 profit
 *
 * Since our memoization array dp[profits.length][capacity+1] stores the results for all the subproblems,
 * we can conclude that we will not have more than N*C subproblems (where ‘N’ is the number of items
 * and ‘C’ is the knapsack capacity). This means that our time complexity will be O(N*C).
 *
 * The above algorithm will be using O(N*C) space for the memoization array. Other than that, we will use O(N) space
 * for the recursion call-stack. So the total space complexity will be O(N*C + N),
 * which is asymptotically equivalent to O(N*C)O(N∗C).
 */
public class ZeroOneKnapsack {
    //Top down approach with memoization

    Integer[][] dp;
    public int maxProfit(int[] profits, int[] weights, int capacity){
        dp = new Integer[profits.length][capacity+1];
        return maxProfitHelper(profits, weights, capacity,0);
    }

    private int maxProfitHelper(int[] profits, int[] weights, int capacity, int index){
        if(capacity <= 0 || index >= profits.length){
            return 0;
        }

        if(dp[index][capacity] != null){
            return dp[index][capacity];
        }
        int profit1 = 0;
        if (weights[index] <= capacity){
            profit1 = profits[index] + maxProfitHelper(profits, weights,
                    capacity - weights[index], index + 1);
        }


        int profit2 = maxProfitHelper(profits, weights, capacity, index + 1);

        dp[index][capacity] = Math.max(profit1, profit2);
        return dp[index][capacity];
    }
    public static void main(String[] args) {
        ZeroOneKnapsack obj = new ZeroOneKnapsack();
        Assert.assertEquals(10, obj.maxProfit(new int[]{ 4, 5, 3, 7 },
                new int[]{2, 3, 1, 4}, 5));
        Assert.assertEquals(10, obj.maxProfitBottomUp(new int[]{ 4, 5, 3, 7 },
                new int[]{2, 3, 1, 4}, 5));
    }

    //Bottom up approach
    public int maxProfitBottomUp(int[] profits, int[] weights, int capacity){
        if(capacity <= 0 || profits.length == 0 || weights.length != profits.length){
            return 0;
        }
        int n = profits.length;
        int[][] dp = new int[n][capacity+1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int cap = 0; cap <= capacity; cap++){
            if(weights[0] <= cap){
                dp[0][cap] = profits[0];
            }
        }

        // process all sub-arrays for all the capacities
        for(int i = 1; i < n; i++){
            for(int cap = 1; cap <= capacity; cap++){
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= cap){
                    profit1 = profits[i] + dp[i-1][cap - weights[i]];
                }
                // exclude the item
                profit2 = dp[i-1][cap];
                // take maximum
                dp[i][cap] = Math.max(profit1, profit2);
            }
        }
        // maximum profit will be at the bottom-right corner.
        return dp[n-1][capacity];
    }
}
