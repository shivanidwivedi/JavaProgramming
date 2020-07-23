package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author shivanidwivedi on 23/07/20
 * @project JavaProgramming
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                set.remove(num);
            }
        }
        int i = 0;
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            result[i++] = itr.next();
        }
        System.out.print(Arrays.toString(result));
        return result;
    }

    public static void main(String s[]){
        SingleNumber3 obj = new SingleNumber3();
        obj.singleNumber(new int[]{1, 2, 1, 3, 2, 4});

    }
}
