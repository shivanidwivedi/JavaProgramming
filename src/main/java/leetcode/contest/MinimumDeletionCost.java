package leetcode.contest;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 05/09/20
 * @project JavaProgramming
 *
 *Given a string s and an array of integers cost where cost[i] is the cost of deleting the character i in s.
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character,
 * the costs of deleting other characters will not change.
 *
 * Example 1:
 *
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 * Example 2:
 *
 * Input: s = "abc", cost = [1,2,3]
 * Output: 0
 * Explanation: You don't need to delete any character because there are no identical letters next to each other.
 * Example 3:
 */
public class MinimumDeletionCost {
    public static int minCost(String s, int[] cost) {
        int minimumCost = 0;
        int i = 0, j = 1;
        while (i < s.length() && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                minimumCost += Math.min(cost[i], cost[j]);
                if(cost[i] < cost[j]){
                    i = j;
                    j++;
                }else j++;
            }else{
                i = j;
                j++;
            }
        }
        return minimumCost;
    }

    public static void main(String[] s){
        Assert.assertEquals(26, minCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1}));
    }
}
