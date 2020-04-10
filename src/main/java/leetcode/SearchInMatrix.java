package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchInMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++ ){
            if(matrix[i].length > 0){
                if (target <= matrix[i][matrix[i].length-1]){
                    return  (Arrays.binarySearch(matrix[i],target) >= 0) ? true : false;
                }
            }
        }
        return false;
    }
}
