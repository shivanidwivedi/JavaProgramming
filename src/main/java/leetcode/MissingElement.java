package leetcode;

/**
 * @author shivanidwivedi on 19/08/20
 * @project JavaProgramming
 *
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
 *
 * Example 1:
 *
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation:
 * The first missing number is 5.
 * Example 2:
 *
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * Example 3:
 *
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation:
 * The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 */
public class MissingElement {
    public static int missingElementLinear(int[] nums, int k) {
        int assumedNumber = nums[0] + k;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= assumedNumber) {
                assumedNumber++;
            } else {
                break;
            }
        }
        return assumedNumber;
    }

    public static int missingElementBinarySearch(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid == left){
                mid++;
            }
            int leftCount = nums[mid] - nums[left] - (mid-left);
            if(leftCount >= k){
                right = mid-1;
            }else{
                k -= leftCount;
                left = mid;
            }
        }
        return nums[left]+k;
    }

    public static void main(String[] s){
        System.out.println(missingElementBinarySearch(new int[]{4,7,9,10}, 1));
        System.out.println(missingElementBinarySearch(new int[]{4,7,9,10}, 3));
        System.out.println(missingElementLinear(new int[]{4,7,9,10}, 1));
        System.out.println(missingElementLinear(new int[]{4,7,9,10}, 3));
    }
}
