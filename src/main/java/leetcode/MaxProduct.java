package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 22/01/20
 * @project JavaProgramming
 */
public class MaxProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*
                nums[nums.length-2]*nums[nums.length-3]);
    }

    public static int maximumProductSinglePass(int[] nums) {
        if (nums.length == 3){
            return nums[0]*nums[1]*nums[nums.length-1];
        }
        int[] min = twoMin(nums);
        int[] max = threeMax(nums);
        return Math.max(min[0]*min[1]*max[0], max[0]*max[1]*max[2]);
    }

    /**
     * returns least and second least min
     * @param arr
     * @return
     */
    static int[] twoMin(int[] arr) {
        int[] mins = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i: arr){
            if (i < mins[0]) {
                mins[1] = mins[0];
                mins[0] = i;
            } else if (i < mins[1]) { //if i is between min1 and min2
                mins[1] = i;
            }
        }
        return mins;
    }

    /**
     * returns first three max
     */
    static int[] threeMax(int[] arr) {
        int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i: arr){
            if (i > max[0]) { //if i is the largest
                max[2] = max[1];
                max[1] = max[0];
                max[0] = i;
            } else if (i > max[1]) { //if i is between max1 and max2
                max[2] = max[1];
                max[1] = i;
            } else if (i > max[2]) { //i is smaller than max1, max2 but larger than max3
                max[2] = i;
            }
        }
        return max;
    }
}