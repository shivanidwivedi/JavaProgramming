package design_questions.tictactoe;

import lombok.Data;
import lombok.Setter;

import java.util.Objects;

/**
 * @author shivanidwivedi on 13/10/20
 * @project JavaProgramming
 */

@Data
public class Move {
    private Position position;
    private Player player;

    public Move(Position position, Player player) throws Exception {
        position.occupy();
        this.position = position;
        this.player = player;
    }

    public boolean isEmpty() {
        return player == null;
    }

    @Override
    public boolean equals(Object obj) {
        if(player == null)
            return false;
        if(obj instanceof Player) {
            return this.player.equals(obj);
        }
        return false;
    }


    @Override
    public String toString() {
        return String.format("Player %s moved to (%d, %d)",player.getType(), position.getRow(), position.getCol());
    }
}
