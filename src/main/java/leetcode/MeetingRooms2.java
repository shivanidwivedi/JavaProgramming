package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shivanidwivedi on 17/07/20
 * @project JavaProgramming
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 * Time Complexity: O(NlogN).
 * Space Complexity: O(N)
 */
public class MeetingRooms2 {
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0 || intervals == null) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(final int[] a, final int[] b){
                return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<>(intervals.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });
        q.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= q.peek()){
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return q.size();
    }
}
