package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 07/04/20
 * @project JavaProgramming
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
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
     * TC: O(amount * coins)
     * SC: O(amount)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeBySort(int[] coins, int amount) {
        int T[] = new int[amount + 1];
        int R[] = new int[amount + 1];
        T[0] = 0;
        for(int i = 1; i<= amount; i++){
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }
        for(int j = 0; j < coins.length; j++){
            for(int i = 1; i <= amount; i++){
                if(i >= coins[j]){
                    T[i] = Math.min(T[i], 1 + T[i - coins[j]]);
                    R[i] = j;
                }
            }
        }
        printCoin(R,coins);
        return T[amount] > amount ? -1 : T[amount];
    }

    private static void printCoin(int[] R, int[] coins){
        if(R[R.length-1] == -1) return;
        int start = R.length - 1;
        while (start != 0){
            int j = R[start];
            start -= coins[j];
        }
    }
}
