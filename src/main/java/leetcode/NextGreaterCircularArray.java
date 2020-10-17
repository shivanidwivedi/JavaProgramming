package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 17/10/20
 * @project JavaProgramming
 *
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
public class NextGreaterCircularArray {
    /**
     * Approach : Brute force : O(n2), SC: O(n)
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = -1;
            for(int j = 1; j < nums.length; j++){
                if(nums[(i+j) % nums.length] > nums[i]){
                    result[i] = nums[(i+j) % nums.length];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,1})));
    }
}
