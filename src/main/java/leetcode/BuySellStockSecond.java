package leetcode;

/**
 * @author shivanidwivedi on 21/01/20
 * @project JavaProgramming
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 */
public class BuySellStockSecond {
    public static int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while (i < prices.length - 1){
            while (i < prices.length - 1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
    public static int maxProfit2(int[] prices){
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                maxprofit += prices[i] - prices[i-1];
            }
        }
        return maxprofit;
    }
}
