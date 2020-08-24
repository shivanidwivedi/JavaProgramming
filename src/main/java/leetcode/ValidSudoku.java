package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 24/08/20
 * @project JavaProgramming
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !isValid(board, i , j)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        return checkRow(board, row) &&
                checkColumn(board, col) &&
                checkBox(board, row - row % 3, col - col % 3);
    }

    private boolean checkRow(char[][] board, int row){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            char val = board[row][i];
            if(val == '.') continue;
            if(set.contains(val)){
                return false;
            }
            set.add(val);
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int col){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char val = board[i][col];
            if (val == '.') continue;
            if (set.contains(val)) return false;
            set.add(val);
        }
        return true;
    }

    private boolean checkBox(char[][] board, int startRow, int startCol){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char val = board[i+startRow][j+startCol];
                if (val == '.') continue;
                if (set.contains(val)) return false;
                set.add(val);
            }
        }
        return true;
    }
}
