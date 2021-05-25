package random;


import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 20/05/21
 * @project JavaProgramming
 *
 * Write a function that takes a list of numbers and a target number,
 * and then returns the number of unique pairs that add up to the target number.
 */
public class APractice1 {
    public int twoSumPairs(int[] nums, int target){
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int count = 0;
        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(num);
                seen.add(target-num);
            }
            set.add(num);
        }
        return count;
    }

    public static void main(String[] args) {
        APractice1 obj = new APractice1();
        Assert.assertEquals(2, obj.twoSumPairs(new int[]{1,1,2,45,46,46}, 47));
        Assert.assertEquals(1, obj.twoSumPairs(new int[]{1,1}, 2));
        Assert.assertEquals(1, obj.twoSumPairs(new int[]{1,5,1,5}, 6));
        Assert.assertEquals(2, obj.twoSumPairs(new int[]{3,1,5,3,3}, 6));
    }
}
