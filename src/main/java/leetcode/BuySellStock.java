package leetcode;

/**
 * @author shivanidwivedi on 17/01/20
 * @project JavaProgramming
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */
public class BuySellStock {
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if(price < minPrice) {
                minPrice = price;
            }
            else if( (price - minPrice) > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
