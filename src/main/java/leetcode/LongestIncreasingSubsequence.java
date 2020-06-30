package leetcode;

/**
 * @author shivanidwivedi on 30/06/20
 * @project JavaProgramming
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return 1;
        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    arr[i] = Math.max(arr[j] + 1, arr[i]);
                }
            }
        }
        int max = maxElement(arr);
        return max;
    }

    private static int maxElement(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
}
