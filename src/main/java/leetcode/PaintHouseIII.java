package leetcode;

/**
 * @author shivanidwivedi on 23/10/20
 * @project JavaProgramming
 * <p>
 * There is a row of m houses in a small city, each house must be painted with one of the n colors
 * (labeled from 1 to n), some houses that has been painted last summer should not be painted again.
 * <p>
 * A neighborhood is a maximal group of continuous houses that are painted with the same color.
 * (For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods  [{1}, {2,2}, {3,3}, {2}, {1,1}]).
 * <p>
 * Given an array houses, an m * n matrix cost and an integer target where:
 * <p>
 * houses[i]: is the color of the house i, 0 if the house is not painted yet.
 * cost[i][j]: is the cost of paint the house i with the color j+1.
 * Return the minimum cost of painting all the remaining houses in such a way that
 * there are exactly target neighborhoods, if not possible return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * Output: 9
 * Explanation: Paint houses of this way [1,2,2,1,1]
 * This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
 * Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.
 * Example 2:
 * <p>
 * Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * Output: 11
 * Explanation: Some houses are already painted, Paint the houses of this way [2,2,1,2,2]
 * This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}].
 * Cost of paint the first and last house (10 + 1) = 11.
 *
 * TC: O(m * t * n * n), SC: O(m * t * n)
 */


// Approach with memoization
public class PaintHouseIII {
    private int INF = 1000001;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int result = dfs(houses, cost, m, n, target, 0, 0, 0);
        return result < INF ? result : -1;
    }

    private int dfs(int[] houses, int[][] cost, int m, int n, int target, int currentHouse,
                    int currentTarget, int prevColor) {
        if (currentHouse == m) {
            return currentTarget == target ? 0 : INF;
        }
        if (currentTarget > target) {
            return INF;
        }
        if (houses[currentHouse] == 0) { //not painted
            int minCost = Integer.MAX_VALUE;
            for (int color = 1; color <= n; color++) {
                int neighbour = currentTarget;
                if (color != prevColor) {
                    neighbour = currentTarget + 1;
                }
                minCost = Math.min(minCost, cost[currentHouse][color - 1] + dfs(houses, cost, m, n, target, currentHouse + 1,
                        neighbour, color));
            }
            return minCost;
        } else { // already painted
            int neighbour = currentTarget;
            if (houses[currentHouse] != prevColor) {
                neighbour = currentTarget + 1;
            }
            return dfs(houses, cost, m, n, target, currentHouse + 1,
                    neighbour, houses[currentHouse]);
        }
    }

    public static void main(String[] args) {
        PaintHouseIII paintHouseIII = new PaintHouseIII();
        System.out.println(paintHouseIII.minCost(new int[]{0, 0, 0, 0, 0},
                new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3));
        System.out.println(paintHouseIII.minCost(new int[]{0, 2, 1, 2, 0},
                new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3));
    }
}
