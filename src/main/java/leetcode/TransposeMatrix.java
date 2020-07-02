package leetcode;

/**
 * @author shivanidwivedi on 02/07/20
 * @project JavaProgramming
 *
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]
 *
 * Time Complexity: O(R * C), where R and C are the number of rows and columns in the given matrix A.
 * Space Complexity: O(R * C), the space used by the answer.
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int[][] answer = new int[C][R];
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                answer[c][r] = A[r][c];
            }
        }
        return answer;
    }
}
