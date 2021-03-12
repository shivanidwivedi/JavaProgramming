package random;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 12/03/21
 * @project JavaProgramming
 */
public class SubarrayEqualsSumPositiveIntegers {
    public int[] getIndex(int[] nums, int sum){
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] result = new int[2];
        int currSum = nums[0];
        int start = 0;
        for(int i = 1; i <= nums.length; i++){
            while (currSum > sum && start < i-1){
                currSum -= nums[start];
                start++;
            }

            if(currSum == sum){
                result[0] = start;
                result[1] = i-1;
                return result;
            }
            if(i < nums.length){
                currSum += nums[i];
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        SubarrayEqualsSumPositiveIntegers obj = new SubarrayEqualsSumPositiveIntegers();
        Assert.assertEquals(Arrays.toString(new int[]{1,4}),
                Arrays.toString(obj.getIndex(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23)));
        Assert.assertEquals(Arrays.toString(new int[]{1,4}),
                Arrays.toString(obj.getIndex(new int[]{1, 4, 0, 0, 3, 10, 5}, 7)));
        Assert.assertEquals(Arrays.toString(new int[]{}),
                Arrays.toString(obj.getIndex(new int[]{1, 4}, 0)));
    }
}
