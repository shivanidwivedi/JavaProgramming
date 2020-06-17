package leetcode;

/**
 * @author shivanidwivedi on 17/06/20
 * @project JavaProgramming
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundedRegion {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        if(n == 0) return;
        for(int i = 0; i < m; i++) if(board[i][0] == 'O') dfs(board,i,0);
        for(int i = 0; i < n; i++) if(board[0][i] == 'O') dfs(board,0,i);
        for(int i = 0; i < m; i++) if(board[i][n-1] == 'O') dfs(board,i,n-1);
        for(int i = 0; i < n; i++) if(board[m-1][i] == 'O') dfs(board,m-1,i);
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if(board[i][j] == '#') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int row, int col){
        if(row == board.length || row == -1 || col == -1 ||
                col == board[row].length){
            return;
        }
        if(board[row][col] == 'X' || board[row][col] == '#') return;
        board[row][col] = '#';
        dfs(board,row-1,col);
        dfs(board,row,col-1);
        dfs(board,row+1,col);
        dfs(board,row,col+1);
    }
}
