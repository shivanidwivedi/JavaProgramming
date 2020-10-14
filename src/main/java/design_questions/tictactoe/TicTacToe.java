package design_questions.tictactoe;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 13/10/20
 * @project JavaProgramming
 */
public class TicTacToe {

    public static void main(String[] args) {

        Player p1 = new Player(BOARDVALUE.X);
        Player p2 = new Player(BOARDVALUE.O);
        Game game = new Game(p1, p2);
        p1.move(0,0);
        p2.move(0,1);
        p1.move(1,0);
        p2.move(2,1);
        p1.move(2,0);
        Assert.assertTrue(game.isGameOver());
        //Assert.assertThrows("Game is over, not allowed to play anymore",IllegalStateException.class, () -> p2.move(1,1));

        game.start();
        p1.move(0,0);
        p2.move(0,1);
        p1.move(1,0);
        p2.move(2,1);
        p1.move(2,1); //should throw exception
        Assert.assertFalse(game.isGameOver());
    }
}
