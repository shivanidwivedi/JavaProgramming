package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 15/09/20
 * @project JavaProgramming
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        addPermutations(nums, 0, result);
        return result;
    }

    public static void addPermutations(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> current = new ArrayList<>();
            for (int n : nums) {
                current.add(n);
            }
            result.add(current);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                addPermutations(nums, start + 1, result);
                swap(nums, start, i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] s){
        System.out.println(permute(new int[]{1,2,3}));
    }
}
