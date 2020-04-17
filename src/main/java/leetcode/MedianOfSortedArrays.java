package leetcode;

/**
 * @author shivanidwivedi on 16/04/20
 * @project JavaProgramming
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double output = 0.0;
        if (nums1.length == 0 && nums2.length != 0) {
            if (nums2.length % 2 != 0) {
                return nums2[(int) Math.floor(nums2.length / 2)];
            } else {
                return (nums2[nums2.length / 2] + nums2[(nums2.length / 2) - 1]) * 0.5;
            }
        }
        if (nums1.length != 0 && nums2.length == 0) {
            if (nums1.length % 2 != 0) {
                return nums1[(int) Math.floor(nums1.length / 2)];
            } else {
                return (nums1[nums1.length / 2] + nums1[(nums1.length / 2) - 1]) * 0.5;
            }
        }
        int[] mergedArray = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
           if (nums1[i] <= nums2[j]){
               mergedArray[k] = nums1[i];
               k++; i++;
           } else {
               mergedArray[k] = nums2[j];
               k++; j++;
           }
        }
        while(i < nums1.length){
            mergedArray[k] = nums1[i];
            k++; i++;
        }
        while(j < nums2.length){
            mergedArray[k] = nums2[j];
            k++; j++;
        }
        if (mergedArray.length % 2 != 0){
            return mergedArray[(int) Math.floor(mergedArray.length / 2)];
        } else return (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) -1]) * 0.5;
    }
}
