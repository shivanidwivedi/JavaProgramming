package random;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 03/06/21
 * @project JavaProgramming
 */
public class APractice7 {
    int result;
    public int shoppingOption(int[][] prices, int budget) {
        this.result = 0;
        for(int[] row:prices){
            Arrays.sort(row);
        }
        backtrack(prices, 0, budget);
        return result;
    }

    private void backtrack(int[][] prices, int index, int remainingBudget) {
        if (index < prices.length) {
            int[] current = prices[index];
            for (int i = 0; i < current.length; i++) {
                int rem = remainingBudget - current[i];
                if (rem < 0) {
                    return;
                }
                if (index < prices.length - 1) {
                    if (rem == 0) {
                        return;
                    }
                    backtrack(prices, index + 1, rem);
                } else {
                    result++;
                }
            }
        }
    }

    public static void main(String[] args) {
        APractice7 obj = new APractice7();
        System.out.println(obj.shoppingOption(new int[][]{{2,3},{4},{2,3},{1,2}}, 10));
        System.out.println(obj.shoppingOption(new int[][]{{2,3,5},{5},{2,3,10},{1,2}}, 11));
    }
}
