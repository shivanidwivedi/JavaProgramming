package design_questions.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


/**
 * @author shivanidwivedi on 05/11/20
 * @project JavaProgramming
 */
public class GameTest {

    private Game game;
    private Move prevMove;
    private boolean isGameOver;
    private Board board;
    private GameLogs gameLogs;
    private Player p1, p2;

    @Before
    public void setup() {
        prevMove = mock(Move.class);
        board = mock(Board.class);
        gameLogs = mock(GameLogs.class);

        p1 = new Player(BOARDVALUE.O);
        p2 = new Player(BOARDVALUE.X);

        game = new Game(p1, p2);
        game.setPreviousMove(prevMove);
    }

    @Test
    public void move_illegalMove_IllegalStateException() {
        Assert.assertNotNull(prevMove);
        Assert.assertNotNull(board);
        Assert.assertNotNull(gameLogs);


        when(prevMove.getPlayer()).thenReturn(p1);

        try {
            game.move(0, 0, p1);
            Assert.assertTrue("this must never execute",false);
        } catch (Exception e){
            Assert.assertNotNull(e);
            Assert.assertTrue(e instanceof IllegalStateException);
            Assert.assertEquals("Illegal Move: Player O us not allowed to move", e.getMessage());
        }
    }
}