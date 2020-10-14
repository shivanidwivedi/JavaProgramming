package design_questions.tictactoe;

/**
 * @author shivanidwivedi on 13/10/20
 * @project JavaProgramming
 */
public class Board {
    private BOARDVALUE[][] board;

    public Board() {
        board = new BOARDVALUE[3][3];
        reset();
    }

    public void update(Move move) {
        board[move.getPosition().getRow()][move.getPosition().getCol()] = move.getPlayer().getType();
    }

    public boolean isWinner(Move move){
        BOARDVALUE type = move.getPlayer().getType();
        int row = move.getPosition().getRow();
        int col = move.getPosition().getCol();

        if(isIdenticalColumn(col, type) || isIdenticalRow(row, type) || isIdenticalDiagonal(type)
        || isIdenticalAntiDiagonal(type)){
            return true;
        }
        return false;
    }

    private boolean isIdenticalDiagonal(BOARDVALUE type) {
        if (board[0][0].equals(type) && board[1][1].equals(type) && board[2][2].equals(type)){
            return true;
        }
        return false;
    }

    private boolean isIdenticalAntiDiagonal(BOARDVALUE type) {
        if (board[0][2].equals(type) && board[1][1].equals(type) && board[2][0].equals(type)){
            return true;
        }
        return false;
    }

    private boolean isIdenticalRow(int row, BOARDVALUE type) {
        for (int col = 0; col < 3; col++){
            if(!board[row][col].equals(type)){
                return false;
            }
        }
        return true;
    }

    public boolean isOccupied(int x, int y) {
        return !board[x][y].equals(BOARDVALUE.EMPTY);
    }

    private boolean isIdenticalColumn(int col, BOARDVALUE type) {
        for (int row = 0; row < 3; row++){
            if(!board[row][col].equals(type)){
                return false;
            }
        }
        return true;
    }

    public void reset(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = BOARDVALUE.EMPTY;
            }
        }
    }
}

enum BOARDVALUE {
    X, O, EMPTY;
}
