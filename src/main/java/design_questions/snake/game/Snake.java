package design_questions.snake.game;

import com.google.inject.internal.cglib.core.$ClassInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author shivanidwivedi on 15/10/20
 * @project JavaProgramming
 */

@Data
@Slf4j
public class Snake {
    private LinkedList<Cell> snakeParts = new LinkedList<>();
    private Cell head;

    public Snake(Cell initialPosition) {
        head = initialPosition;
        snakeParts.add(initialPosition);
        head.setCellType(CellType.SNAKE);
    }

    public void grow() {
        snakeParts.add(head);
        log.info(String.format("Growing snake to size %d", size()));
        log.debug(String.format("snake print: %s", snakeParts));
    }

    /**
     * @param nextCell
     */
    public void move(Cell nextCell) {
        deleteLastCell();
        addNewCell(nextCell);
        log.info(String.format("moved to %s",nextCell.toString()));
    }

    private void deleteLastCell() {
        Cell tail = snakeParts.removeLast();
        tail.setCellType(CellType.EMPTY);
    }

    private void addNewCell(Cell nextCell) {
        head = nextCell;
        head.setCellType(CellType.SNAKE);
        snakeParts.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell) {
        for (Cell cell : snakeParts) {
            if (cell == nextCell) {
                log.error(String.format("Crashed at cell %s",cell));
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.snakeParts.size();
    }
}
