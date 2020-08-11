package leetcode;

/**
 * @author shivanidwivedi on 10/08/20
 * @project JavaProgramming
 *
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 *
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */
public class TicTacToe {
    private static int[] rows;
    private static int[] cols;
    private static int diagonal, anti_diag, n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    public static int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if (row == col) diagonal += toAdd;
        if (col == cols.length - row - 1) anti_diag += toAdd;

        if (rows[row] == n || cols[col] == n || diagonal == n || anti_diag == n) {
            return 1;
        }
        if (rows[row] == -n || cols[col] == -n || diagonal == -n || anti_diag == -n) {
            return 2;
        }
        return 0;
    }

    public static void main(String[] s){
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println(move(0,0,1));
        System.out.println(move(0,2,2));
        System.out.println(move(2,2,1));
        System.out.println(move(1,1,2));
        System.out.println(move(2,0,1));
        System.out.println(move(1,0,2));
        System.out.println(move(2,1,1));
    }
}
