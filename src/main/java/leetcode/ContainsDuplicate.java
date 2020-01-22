package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author shivanidwivedi on 21/01/20
 * @project JavaProgramming
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    /**
     * Taking a lot of time, hence more time complexity using Hashmap
     */
    public static boolean containsDuplicateHashMap(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                return true;
            }
        }
        return false;
    }
}
