package leetcode;

/**
 * @author shivanidwivedi on 28/09/20
 * @project JavaProgramming
 * A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this
 * board position during the course of a valid tic-tac-toe game.
 *
 * The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.
 *
 * Here are the rules of Tic-Tac-Toe:
 *
 * Players take turns placing characters into empty squares (" ").
 * The first player always places "X" characters, while the second player always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Example 1:
 * Input: board = ["O  ", "   ", "   "]
 * Output: false
 * Explanation: The first player always plays "X".
 *
 * Example 2:
 * Input: board = ["XOX", " X ", "   "]
 * Output: false
 * Explanation: Players take turns making moves.
 *
 * Example 3:
 * Input: board = ["XXX", "   ", "OOO"]
 * Output: false
 *
 * Example 4:
 * Input: board = ["XOX", "O O", "XOX"]
 * Output: true
 *
 * TC and SC : O(1)
 */
public class ValidTicTacToeState {
    public static boolean validTicTacToe(String[] board) {
        if(board.length == 0) return true;
        int xCount = 0, oCount = 0;
        for(String str : board){
            for(char ch : str.toCharArray()){
                if(ch == 'X'){
                    xCount++;
                }
                if(ch == 'O'){
                    oCount++;
                }
            }
        }
        if(xCount != oCount && xCount-1 != oCount){
            return false;
        }
        if(win(board, 'X') && xCount-1 != oCount){
            return false;
        }
        if(win(board, 'O') && xCount != oCount){
            return false;
        }
        return true;
    }

    private static boolean win(String[] board, char player){
        // check rows and columns
        for(int i = 0; i < 3; i++){
            if(player == board[0].charAt(i) && player == board[1].charAt(i) &&
                    player == board[2].charAt(i)){
                return true;
            }
            if(player == board[i].charAt(0) && player == board[i].charAt(1) &&
                    player == board[i].charAt(2)){
                return true;
            }
        }
        //checks diagonal
        if(player == board[0].charAt(0) && player == board[1].charAt(1) &&
                player == board[2].charAt(2)){
            return true;
        }
        //checks anti-diagonal
        if(player == board[2].charAt(0) && player == board[1].charAt(1) &&
                player == board[0].charAt(2)){
            return true;
        }
        return false;
    }

    public static void main(String[] s){
        System.out.println(validTicTacToe(new String[]{"O  ", "   ", "   "}));
        System.out.println(validTicTacToe(new String[]{"XOX", " X ", "   "}));
        System.out.println(validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        System.out.println(validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }
}
