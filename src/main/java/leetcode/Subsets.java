package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 10/06/20
 * @project JavaProgramming
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * Time complexity: O(N×2^N) to generate all subsets and then copy them into output list.
 *
 * Space complexity: O(N×2^N). This is exactly the number of solutions for subsets
 * multiplied by the number NN of elements to keep for each subset.
 */
public class Subsets {
    public List<List<Integer>> subsetsCascading(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for(int i : nums){
            List<List<Integer>> newSubset = new ArrayList<>();
            for(List<Integer> current : result){
                newSubset.add(new ArrayList<Integer>(current){{add(i);}});
            }
            for(List<Integer> current : newSubset){
                result.add(current);
            }
        }
        return result;
    }
}
