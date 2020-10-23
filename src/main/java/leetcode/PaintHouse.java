package leetcode;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 23/10/20
 * @project JavaProgramming
 *
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses
 * such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with the color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 *
 * Example 1:
 *
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 * Example 2:
 *
 * Input: costs = []
 * Output: 0
 * Example 3:
 *
 * Input: costs = [[7,6,2]]
 * Output: 2
 */
public class PaintHouse {
    private int[][] costs;
//Brute Force, [TIME LIMIT EXCEEDED], TC: O(2^n), SC: O(n)

    public int minCostBruteForce(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        this.costs = costs;
        return Math.min(paintCost(0,0), Math.min(paintCost(0,1), paintCost(0,2)));
    }
    private int paintCost(int n, int color){
        int totalCost = costs[n][color];
        if(n == costs.length - 1){
        }
        else if(color == 0){
            totalCost += Math.min(paintCost(n+1, 1), paintCost(n+1, 2));
        }
        else if(color == 1){
            totalCost += Math.min(paintCost(n+1, 0), paintCost(n+1, 2));
        }
        else if(color == 2){
            totalCost += Math.min(paintCost(n+1, 0), paintCost(n+1, 1));
        }
        return totalCost;
    }

    /**
     * This approach is using the memoization
     */
    HashMap<String, Integer> memo;
    //Memoization, TC: O(n), SC: O(n)
    public int minCostMemoization(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        this.costs = costs;
        this.memo = new HashMap<>();
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCostMemo(int n, int color) {
        if(memo.containsKey(getKey(n, color))){
            return memo.get(getKey(n, color));
        }
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCostMemo(n + 1, 1), paintCostMemo(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCostMemo(n + 1, 0), paintCostMemo(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCostMemo(n + 1, 0), paintCostMemo(n + 1, 1));
        }
        memo.put(getKey(n, color), totalCost);
        return totalCost;
    }

    private String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }

    /**
     * Using Bottom up DP, TC: O(n), SC: O(1)
     * @param costs
     * @return
     */
    public int minCostBottomUpDP(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        for(int i = costs.length - 2; i >= 0; i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCostMemoization(new int[][]{
                {17,2,17},{16,16,5},{14,3,19}
        }));
        System.out.println(paintHouse.minCostBottomUpDP(new int[][]{
                {17,2,17},{16,16,5},{14,3,19}
        }));
    }
}
