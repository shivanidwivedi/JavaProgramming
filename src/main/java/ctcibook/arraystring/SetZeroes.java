package ctcibook.arraystring;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 */
public class SetZeroes {
    public void setZeros(int[][] matrix){
        boolean[] setRow = new boolean[matrix.length];
        boolean[] setCol = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    setRow[i] = true;
                    setCol[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(setRow[i] || setCol[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
