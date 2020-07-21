package leetcode;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 02/02/20
 * @project JavaProgramming
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 */
//O(n^2), O(n)
public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
    //Using HashMap, O(n), O(n)
    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
