package leetcode;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author shivanidwivedi on 21/04/20
 * @project JavaProgramming
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
//Method-1: Using sort method, TC: O(N log N)
public class KthLargestInArray {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //Method-2 : Using Heap, TC: O(N log k)
    public static int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums){
            queue.add(num);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    //Method-2 : Using quickselect
    public int findKthLargestQuickSelect(int[] nums, int k) {
        return quickselect(nums, 0, nums.length-1, nums.length-k);
    }

    private int quickselect(int[] nums, int start, int end, int k) {
        int mid = partition(nums, start, end);
        if (mid == k) {
            return nums[mid];
        }
        if (k > mid) {
            return quickselect(nums, mid+1, end, k);
        }
        return quickselect(nums, start, mid-1, k);
    }

    private int getRandom(int min, int max) {
        // java.lang.IllegalArgumentException: bound must be positive
        if (max == min) return min;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private int partition(int[] nums, int start, int end) {
        // instead of picking end, pick it randomly for best average case performance
        int pivotIndex = getRandom(start, end);
        swap(nums, pivotIndex, end);
        int i = start;
        int index = start;
        while (i <= end-1) {
            if (nums[i] <= nums[end]) {
                swap(nums, i, index);
                index++;
            }
            i++;
        }
        swap(nums, index, end);
        return index;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestInArray obj = new KthLargestInArray();
        Assert.assertEquals(5, obj.findKthLargestQuickSelect(new int[]{3,2,1,5,6,4}, 2));
        Assert.assertEquals(4, obj.findKthLargestQuickSelect(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}


