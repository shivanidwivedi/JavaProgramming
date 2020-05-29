package leetcode;

/**
 * @author shivanidwivedi on 28/05/20
 * @project JavaProgramming
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * Time Complexity :O(M×N)
 * Space Complexity :O(1)
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false, isFirstColZero = false;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                if(matrix[i][j] == 0){
                    if (i == 0) {
                        isFirstRowZero = true;
                    }
                    if (j == 0) {
                        isFirstColZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < rowSize; i++){
            for(int j = 1; j < colSize; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(isFirstRowZero){
            for (int i = 0; i < colSize; i++) {
                matrix[0][i] = 0;
            }
        }
        if(isFirstColZero){
            for(int i = 0; i < rowSize; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
