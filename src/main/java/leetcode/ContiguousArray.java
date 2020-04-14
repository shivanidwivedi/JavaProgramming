package leetcode;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 13/04/20
 * @project JavaProgramming
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int maxlength = Integer.MIN_VALUE;
        int i =0,j=0;
        for(i = 0; i < nums.length; i++){
            int zeroCount = 0, oneCount = 0;
            for(j = i; j < nums.length; j++){
                if (nums[j] == 0) zeroCount++;
                else oneCount++;
                if (zeroCount == oneCount)
                    maxlength = Math.max(maxlength, j - i + 1);
            }

        }
        return maxlength;
    }

    /**
     * Method-2 : Using HashMap
     * @param nums
     * @return
     */
    //Time complexity : O(n).The entire array is traversed only once.
    //Space complexity : O(n).Maximum size of the HashMap map will be n, if all the elements are either 1 or 0.
    public static int findMaxlengthHM(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            count += (nums[i]==1) ? -1 : 1;
            if(map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            }
            else {
                map.put(count,i);
            }

        }
        return maxLength;
    }
}
