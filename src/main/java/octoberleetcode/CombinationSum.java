package octoberleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 02/10/20
 * @project JavaProgramming
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 * Example 4:
 *
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 * Example 5:
 *
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sumHelper(candidates, 0, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void sumHelper(int[] candidates, int sum, int index, int target, List<Integer> list, List<List<Integer>> result){
        if(sum >= target){
            if(sum == target){
                result.add(list);
            }
            return;
        }
        for(int i = index; i < candidates.length; i++){
            sum += candidates[i];
            list.add(candidates[i]);
            sumHelper(candidates, sum, i, target, new ArrayList<>(list), result);
            list.remove(list.size()-1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] s){
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
        System.out.println(combinationSum(new int[]{2},1));
        System.out.println(combinationSum(new int[]{1},2));
        System.out.println(combinationSum(new int[]{},7));
    }
}
