package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shivanidwivedi on 17/09/20
 * @project JavaProgramming
 */
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int count = 0;
        for(int key : map.keySet()){
            if(map.get(key) > Math.floor(n/3)){
                result.add(key);
                count++;
                if(count > 1){
                    break;
                }
            }
        }
        return result;
    }
    //TC: O(n), SC: O(1)
    public static List<Integer> majorityElementOptimized(int[] nums) {
        int n = nums.length;

        int count1 = 0;
        int count2 = 0;
        Integer element1 = null;
        Integer element2 = null;

        List<Integer> result = new ArrayList<>();

        for(int num : nums){
            if(element1 != null && num == element1){
                count1++;
            }else if(element2 != null && num == element2){
                count2++;
            }else if(count1 == 0){
                element1 = num;
                count1++;
            }else if(count2 == 0){
                element2 = num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(element1 != null && num == element1){
                count1++;
            }
            if(element2 != null && num == element2){
                count2++;
            }
        }
        if(count1 > Math.floor(n/3)){
            result.add(element1);
        }

        if(count2 > Math.floor(n/3)){
            result.add(element2);
        }
        return result;
    }

    public static void main(String[] s){
        System.out.println(majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
}
