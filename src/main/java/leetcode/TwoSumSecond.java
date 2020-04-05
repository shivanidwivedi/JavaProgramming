package leetcode;

import java.util.HashMap;

/**
 * @author shivanidwivedi on 22/01/20
 * @project JavaProgramming
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 */
public class TwoSumSecond {
    public static int[] twoSumHashMap(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int output[] = new int[2];
        for (int i = 0; i < numbers.length; i++){
            if (map.containsKey(target - numbers[i])){
                output[0] = map.get(target - numbers[i]);
                output[1] = i+1;
                break;
            }else {
                map.put(numbers[i], i+1);
            }
        }
        return output;
    }

    /**
     * Time complexity : O(n). Each of the n elements is visited at most once, thus the time complexity is O(n).
     * Space complexity : O(1). We only use two indexes, the space complexity is O(1).
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
       while (i < j){
           if (numbers[i] + numbers[j] == target){
               return new int[]{i + 1,j + 1};
           }else if (numbers[i] + numbers[j] < target){
               i++;
           }else {
               j--;
           }
       }
        return new int[]{-1,-1};
    }
}
