package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author shivanidwivedi on 20/05/20
 * @project JavaProgramming
 * Given two arrays, write a function to compute their intersection.
 * Time complexity: O(n+m), where n and m are the lengths of the arrays. We iterate through the first, and then through the second array; insert and lookup operations in the hash map take a constant time.
 *
 * Space complexity: O(min(n,m)). We use hash map to store numbers (and their counts) from the smaller array.
 */
public class IntersectionOfArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0 || nums1.length >= 1 && nums2.length == 0
                || nums1.length == 0 && nums2.length >= 1){
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                result.add(num);
                map.put(num,map.getOrDefault(num,0) - 1);
            }
        }
        int[] itemsArray = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            itemsArray[i] = result.get(i);
        }
        return itemsArray;
    }
}
