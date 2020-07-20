package leetcode;

import java.util.Random;

/**
 * @author shivanidwivedi on 20/07/20
 * @project JavaProgramming
 *
 * Shuffle a set of numbers without duplicates.
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 * Time complexity :O(n), SC : O(n)
 */
public class ShuffleArray {
    private int[] array;
    private int[] original;

    Random r = new Random();

    private int randomRange(int min, int max){
        return r.nextInt(max-min)+min;
    }

    private void swapAt(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < array.length; i++){
            swapAt(i, randomRange(i, array.length));
        }
        return array;
    }
}
