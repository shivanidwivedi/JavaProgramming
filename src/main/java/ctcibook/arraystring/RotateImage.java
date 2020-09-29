package ctcibook.arraystring;

/**
 * @author shivanidwivedi on 29/09/20
 * @project JavaProgramming
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateImage {
    public void rotate(int[][] matrix, int n){
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < (n/2); j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
