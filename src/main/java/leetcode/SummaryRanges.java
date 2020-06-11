package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 11/06/20
 * @project JavaProgramming
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i= 0, j = 0; j < nums.length; j++){
            if(j + 1 < nums.length && nums[j+1] == nums[j] + 1){
                continue;
            }
            if(i == j){
                result.add(nums[i] + "");
            }else{
                result.add(nums[i] + "->" + nums[j]);
            }
            i = j+1;
        }
        return result;
    }
}
