package leetcode;

/**
 * @author shivanidwivedi on 15/06/20
 * @project JavaProgramming
 */
public class FirstLastPosition {
    static int[] res = new int[] {-1,-1};
    public static int[] searchRange(int[] nums, int target) {
        search_first(nums, target, 0, nums.length-1);
        search_last(nums,target, 0, nums.length-1);
        return res;
    }

    public static void search_first(int[] nums, int target, int left, int right){
        while(left<= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                res[0] = mid;
                right = mid -1;
            } else if( nums[mid] > target )
            {
                right = mid-1;
            }else
                left = mid +1;
        }
    }

    public static void search_last(int[] nums, int target, int left, int right){
        while(left<= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                res[1] = mid;
                left = mid +1;
            } else if( nums[mid] > target )
            {
                right = mid-1;
            }else
                left = mid +1;
        }
    }
}
