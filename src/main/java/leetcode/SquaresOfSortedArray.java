package leetcode;


import java.util.Arrays;

/**
 * @author shivanidwivedi on 23/10/20
 * @project JavaProgramming
 *
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int[] result = new int[A.length];
        int i = result.length-1;
        while (high >= low) {
            int h = Math.abs(A[high]);
            int l = Math.abs(A[low]);
            if (h >= l) {
                result[i] = A[high] * A[high];
                high--;
            } else {
                result[i] = A[low] * A[low];
                low++;
            }
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray sorted = new SquaresOfSortedArray();
        System.out.println(Arrays.toString(sorted.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sorted.sortedSquares(new int[]{-7,-3,2,3,11})));
    }
}
