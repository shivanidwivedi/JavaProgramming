package design_questions.snake.game;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shivanidwivedi on 15/10/20
 * @project JavaProgramming
 */

@Data
@Slf4j
public class Board {
    private int rowSize, colSize;
    private Cell[][] cells;

    public Board(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        cells = new Cell[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void generateFood() {
        log.info("Generating food");
        int row = 0, col = 0;
        while (true) {
            row = (int) (Math.random() * rowSize);
            col = (int) (Math.random() * colSize);
            if (cells[row][col].getCellType() != CellType.SNAKE) {
                break;
            }
        }
        cells[row][col].setCellType(CellType.FOOD);
        log.info(String.format("Food generation completed at (%d, %d)", row, col));
    }

    public void print() {
        System.out.println(this.toString());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                builder.append(cells[i][j].getCellType().value+" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
