package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author shivanidwivedi on 16/04/20
 * @project JavaProgramming
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */

/**
 * Method-1 : Using two heaps
 * TC: o(log n): O(5 log n) + O(1) ~ o(log n).
 *
 * At worst, there are three heap insertions and two heap deletions from the top. Each of these takes about O(logn) time.
 * Finding the mean takes constant O(1) time since the tops of heaps are directly accessible.
 * Space complexity: O(n) linear space to hold input in containers.
 */
public class MedianFinder {
    public MedianFinder() {

    }
    //create 2 heaps- minHeap and maxHeap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (minHeap.size() < maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else return ((double)minHeap.peek() +maxHeap.peek())*0.5;
    }

}
