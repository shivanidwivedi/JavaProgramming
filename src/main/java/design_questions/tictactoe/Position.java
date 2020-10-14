package design_questions.tictactoe;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author shivanidwivedi on 13/10/20
 * @project JavaProgramming
 */

@Getter
@ToString
public class Position {
    private int row;
    private int col;
    private boolean isAvailable;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
        this.isAvailable = true;
    }

    public boolean isValid(){
        if(this.row < 0 || this.col < 0 ||
        this.row > 2 || this.col > 2 || !isAvailable){
            throw new IllegalArgumentException(String.format("Invalid position: (%d, %d)", this.row, this.col));
        }
        return true;
    }

    public void occupy() throws Exception {
        if(isValid()) {
            this.isAvailable = false;
        }
    }
}
