package leetcode;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author shivanidwivedi on 11/08/20
 * @project JavaProgramming
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 * TC:O(N), SC:O(N)
 */
public class DegreeOfArray {
    public static int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(),
                count = new HashMap<>();

        //for each element store left index in the left map, right index in the right map
        //and frequency in count map
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(left.get(x) == null){
                left.put(x,i);
            }
            right.put(x,i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for(int x : count.keySet()){
            if(count.get(x) == degree){
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] s){
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}
