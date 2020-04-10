package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {

    /**
     * O(nLogn) - sorting method
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeBySort(int[] coins, int amount) {
        int numberOfCoins = 0;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--){
            if (coins[i] <= amount){
                numberOfCoins += amount/coins[i];
                amount = amount % coins[i];
            }
        }
        return (amount == 0) ? numberOfCoins : -1;
    }
}
