package design_questions.tictactoe;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author shivanidwivedi on 13/10/20
 * @project JavaProgramming
 */
@Data
@EqualsAndHashCode
public class Player {
    private BOARDVALUE type;
    private Game game;

    public Player(BOARDVALUE type){
        this.type = type;
    }

    public void move(int x, int y) {
        game.move(x, y, this);
    }


}
