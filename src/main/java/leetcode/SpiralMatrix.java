package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shivanidwivedi on 11/04/20
 * @project JavaProgramming
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
//Time Complexity: O(N), where N is the total number of elements in the input matrix. We add every element in the matrix to our final answer.
//Space Complexity: O(N), the information stored in ans.
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new LinkedList<>();
            if(matrix.length == 0){
                return result;
            }
            int R1 = 0, R2 = matrix.length - 1;
            int C1 = 0, C2 = matrix[0].length - 1;
            while(C1 <= C2 && R1 <= R2){
                for (int C = C1; C <= C2; C++){
                    result.add(matrix[R1][C]);
                }
                for (int R = R1 + 1; R <= R2; R++){
                    result.add(matrix[R][C2]);
                }
                if(C2 > C1 && R2 > R1) {
                    for (int C = C2 - 1; C > R1; C--) {
                        result.add(matrix[R2][C]);
                    }
                    for (int R = R2; R > C1; R--) {
                        result.add(matrix[R][C1]);
                    }
                }
                C1++;
                R2--;
                R1++;
                C2--;
            }
            return result;
        }
}
