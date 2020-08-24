package leetcode;

import java.util.*;

/**
 * @author shivanidwivedi on 24/08/20
 * @project JavaProgramming
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new ArrayList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if(sum == target){
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> summation : set){
            result.add(summation);
        }
        return result;
    }

    public static void main(String[] s){
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }
}
