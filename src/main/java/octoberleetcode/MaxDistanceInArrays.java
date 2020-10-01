package octoberleetcode;

import java.util.List;

/**
 * @author shivanidwivedi on 01/10/20
 * @project JavaProgramming
 *
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays
 * (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum distance.
 *
 * Example 1:
 * Input:
 * [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 * Output: 4
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 * TC: O(n), SC : O(1)
 */
public class MaxDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        for(int i = 1; i < arrays.size(); i++){
            maxDistance = Math.max(maxDistance,
                    Math.max(Math.abs(arrays.get(i).get(arrays.get(i).size()-1)-min),
                            Math.abs(max - arrays.get(i).get(0))));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return maxDistance;
    }
}
