package design_questions.snake.game;

import lombok.Data;
import lombok.ToString;

/**
 * @author shivanidwivedi on 15/10/20
 * @project JavaProgramming
 */

@Data
@ToString
public class Cell {
    private int row;
    private int col;
    private CellType cellType;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        cellType = CellType.EMPTY;
    }
}


enum CellType {
    FOOD("o"), EMPTY("."), SNAKE("$");

    String value;
    CellType(String value) {
        this.value = value;
    }
}