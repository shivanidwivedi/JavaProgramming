package dataStructure.random;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 30/10/20
 * @project JavaProgramming
 */
public class AbsoluteValueSort {
    static int[] absSort(int[] nums){
        int temp;

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[j]) < Math.abs(nums[minIndex])) {
                    minIndex = j;
                } else if (Math.abs(nums[j]) == Math.abs(nums[minIndex])){
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
            }
            if (minIndex != i) {
                temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }

        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(AbsoluteValueSort.absSort(new int[]{2,-7,-2,-2,0})));
    }
}
