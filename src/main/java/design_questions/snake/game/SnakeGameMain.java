package design_questions.snake.game;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shivanidwivedi on 14/10/20
 * @project JavaProgramming
 */

@Slf4j
public class SnakeGameMain {
    public static void main(String[] args) {
        log.info("Start the game");
        Board board = new Board(5, 5);
        board.print();
        Snake snake = new Snake(new Cell(0, 0));
        Game newGame = new Game(snake, board);
        newGame.direction = newGame.DIRECTION_RIGHT;


        for (int i = 0; i < 4; i++) {
            if (i == 2)
                board.generateFood();
            newGame.update();
            if (i == 3)
                newGame.direction = newGame.DIRECTION_RIGHT;
            if (newGame.gameOver == true)
                break;
        }
        log.info("Game finished");
        board.print();
    }
}
