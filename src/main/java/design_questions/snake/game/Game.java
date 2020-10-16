package design_questions.snake.game;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shivanidwivedi on 15/10/20
 * @project JavaProgramming
 */

@Data
@Slf4j
public class Game {
    //TODO: convert into enum
    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
    private Snake snake;
    private Board board;
    public int direction;
    public boolean gameOver;

    public Game(Snake snake, Board board) {
        this.board = board;
        this.snake = snake;
    }

    public void update() {
        log.info("Going to update the game");
        if (!gameOver) {
            if (direction != DIRECTION_NONE) {
                Cell nextCell = getNextCell(snake.getHead());

                if (snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NONE);
                    gameOver = true;
                    log.error("Game over....");
                } else {
                    snake.move(nextCell);
                    if (nextCell.getCellType() == CellType.FOOD) {
                        snake.grow();
                        board.generateFood();
                    }
                }
            }
        }
    }

    private Cell getNextCell(Cell currentPosition) {
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();

        if (direction == DIRECTION_RIGHT) {
            col++;
        } else if (direction == DIRECTION_LEFT) {
            col--;
        } else if (direction == DIRECTION_UP) {
            row--;
        } else if (direction == DIRECTION_DOWN) {
            row++;
        }

        Cell nextCell = board.getCells()[row][col];
        log.info(String.format("Found next cell %s", nextCell.toString()));
        return nextCell;
    }
}
