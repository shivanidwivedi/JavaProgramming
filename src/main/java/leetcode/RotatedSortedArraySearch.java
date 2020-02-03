package leetcode;

import static java.lang.Math.floor;

/**
 * @author shivanidwivedi on 26/01/20
 * @project JavaProgramming
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 */
public class RotatedSortedArraySearch {
    public static int search(int[] nums, int target) {
        //edge conditions
        if(nums.length == 0) {
            return -1;
        }
        else if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int pivotIndex = getRotationIndex(nums);
        if (pivotIndex == 0){
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        /**
         * Use pivot to divide array and perform binary search
         */
        if (nums[pivotIndex] == target){
            return pivotIndex;
        }else if (nums[0] <= target){ //if first element is less than target then target must be in left array
            return binarySearch(nums, 0, pivotIndex - 1, target);
        } else {
            return binarySearch(nums, pivotIndex + 1, nums.length - 1, target);
        }
    }

    /**
     * Method to get the index of smallest element i.e. Rotation Index
     * @param arr
     * @return 0 if array is sorted
     */
    static int getRotationIndex(int []arr){
        int low = 0;
        int high = arr.length - 1;

        if (arr[low] < arr[high]){
            return 0;
        }
        while (low <= high){
            int pivot = (high + low) / 2;
            if (arr[pivot] > arr[pivot + 1]) {
                return pivot + 1;
            } else {
                if (arr[pivot] < arr[low]){
                    high = pivot - 1;
                }
                else {
                    low = pivot + 1;
                }
            }
        }
        return 0;
    }

    /**
     * Regular binary search
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return
     */
    static int binarySearch(int arr[], int low, int high, int target) {
        if (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearch(arr, low, mid - 1, target);
            } else return binarySearch(arr, mid + 1, high, target);
        }
        return -1;
    }
}
