package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 * @author shivanidwivedi on 13/06/20
 * @project JavaProgramming
 */
public class LargestDivisibleSubset {
    /**
     *
     * @param nums
     * @return
     */
        public List<Integer> largestDivisibleSubset(int[] nums) {
            // Test case with empty set.
            int n = nums.length;
            if (n == 0) return new ArrayList();

            // Container to keep the largest divisible subset
            //   that ends with each of the nums.
            List<ArrayList> EDS = new ArrayList();
            for (int num : nums) EDS.add(new ArrayList());

            /* Sort the original list in ascending order. */
            Arrays.sort(nums);

            /* Calculate all the values of EDS(X_i) */
            for (int i = 0; i < n; ++i) {
                List<Integer> maxSubset = new ArrayList();

                // Find the largest divisible subset of previous elements.
                for (int k = 0; k < i; ++k)
                    if (nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size())
                        maxSubset = EDS.get(k);

                // Extend the found subset with the element itself.
                EDS.get(i).addAll(maxSubset);
                EDS.get(i).add(nums[i]);
            }
            /* Find the largest of EDS values  */
            List<Integer> ret = new ArrayList();
            for (int i = 0; i < n; ++i)
                if (ret.size() < EDS.get(i).size()) ret = EDS.get(i);
            return ret;
        }
}
