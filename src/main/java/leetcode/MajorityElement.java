package leetcode;

/**
 * @author shivanidwivedi on 21/09/20
 * @project JavaProgramming
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int n = nums.length;
        Integer element = null;
        for(int num : nums){
            if(element != null && element == num){
                count++;
            }else if(count == 0){
                element = num;
            }else{
                count--;
            }
        }
        count = 0;
        for(int num : nums){
            if(element != null && num == element) {
                count++;
            }
        }
        if(count > Math.floor(n/2)){
            return element;
        }
        return -1;
    }
    public static void main(String[] s){
        System.out.println(majorityElement(new int[]{1,2,3,1,1,1,1,1}));
    }
}
