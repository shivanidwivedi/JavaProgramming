package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 14/09/20
 * @project JavaProgramming
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            arr[i]= Integer.toString(nums[i]);

        Arrays.sort(arr, (a, b) ->{
            return (b+a).compareTo(a+b);
        });

        String result = "";
        for(int i = 0; i < arr.length; i++){
            result += arr[i];
        }
        if(result.charAt(0) == '0'){
            return "0";
        }
        return result;
    }

    public static void main(String[] s){
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{0,0}));
    }
}
