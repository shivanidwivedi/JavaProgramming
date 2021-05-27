package leetcode;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * @author shivanidwivedi on 27/05/21
 * @project JavaProgramming
 * You have some number of sticks with positive integer lengths.
 * These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.
 *
 * You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y.
 * You must connect all the sticks until there is only one stick remaining.
 *
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 *
 * Input: sticks = [2,4,3]
 * Output: 14
 * Explanation: You start with sticks = [2,4,3].
 * 1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks = [5,4].
 * 2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
 * There is only one stick left, so you are done. The total cost is 5 + 9 = 14.
 *
 */

public class MinimumCostConnectSticks {
    public int connectSticks(int[] sticks) {
        if(sticks.length == 1){
            return 0;
        }
        int minCost = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int stick : sticks){
            q.add(stick);
        }

        while(q.size() > 1){
            int s1 = q.remove();
            int s2 = q.remove();
            minCost += (s1 + s2);
            q.add(s1+s2);
        }
        return minCost;
    }

    public static void main(String[] args) {
        MinimumCostConnectSticks obj = new MinimumCostConnectSticks();
        Assert.assertEquals(14, obj.connectSticks(new int[]{2,4,3}));
        Assert.assertEquals(30, obj.connectSticks(new int[]{1,8,3,5}));
        Assert.assertEquals(0, obj.connectSticks(new int[]{5}));
    }
}
