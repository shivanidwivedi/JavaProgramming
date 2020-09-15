package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author shivanidwivedi on 15/09/20
 * @project JavaProgramming
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutiveBySorting(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int current = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    current += 1;
                }else{
                    longest = Math.max(longest, current);
                    current = 1;
                }
            }
        }
        return Math.max(longest, current);
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int current = 1;

                while(set.contains(currentNum+1)){
                    current++;
                    currentNum++;
                }
                longest = Math.max(current, longest);
            }
        }
        return longest;
    }

    public static void main(String[] s){
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
