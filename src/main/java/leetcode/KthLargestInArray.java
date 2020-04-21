package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

}


