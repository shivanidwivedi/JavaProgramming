package leetcode;

/**
 * @author shivanidwivedi on 21/07/20
 * @project JavaProgramming
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j))
                    return true;
            }
        }


        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(index) != board[row][col])
            return false;

        char temp = board[row][col];
        board[row][col] = ' ';
        boolean found = false;

        found = dfs(board, word, index + 1, row + 1, col) ||
                dfs(board, word, index + 1, row - 1, col) ||
                dfs(board, word, index + 1, row, col + 1) ||
                dfs(board, word, index + 1, row, col - 1);
        board[row][col] = temp;
        return found;
    }
}
