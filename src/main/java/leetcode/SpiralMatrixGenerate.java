package leetcode;

/**
 * @author shivanidwivedi on 13/09/20
 * @project JavaProgramming
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * TC: O(n^2)
 * SC: O(1)
 */
public class SpiralMatrixGenerate {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        for(int layer = 0; layer < (n+1)/2; layer++){
            for(int i = layer; i < n-layer; i++){
                matrix[layer][i] = count;
                count++;
            }
            for(int i = layer+1; i < n-layer; i++){
                matrix[i][n-layer-1] = count;
                count++;
            }
            for(int i = layer+1; i < n-layer; i++){
                matrix[n-layer-1][n-i-1] = count;
                count++;
            }
            for(int i = layer+1; i < n-layer-1; i++){
                matrix[n-i-1][layer] = count;
                count++;
            }
        }
        return matrix;
    }

    public static void main(String[] s){
        System.out.println(generateMatrix(3));
    }
}
