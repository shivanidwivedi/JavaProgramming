package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author shivanidwivedi on 25/01/20
 * @project JavaProgramming
 */
public class ArrayDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static List<Integer> findDuplicatesBySorting(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] == nums[i]){
                list.add(nums[i]);
            }
        }
        return list;
    }
}
