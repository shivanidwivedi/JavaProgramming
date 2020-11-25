package design_questions.tictactoe;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shivanidwivedi on 13/10/20
 * @project JavaProgramming
 */
@Data
@Slf4j
public class Game {

    private Board board;
    private Queue<Player> players;
    private GameLogs gameLogs;
    private boolean isGameOver;
    private Move previousMove;

    public Game(Player p1, Player p2) {
        board = new Board();
        players = new LinkedList<>();
        players.add(p1);
        players.add(p2);
        p1.setGame(this);
        p2.setGame(this);
        this.gameLogs = new GameLogs();
    }

    private Game() { //cannot create a game without players

    }

    public void start() {
        isGameOver = false;
        board.reset();
        log.info("starting a new game...");
    }


    public Player move(int x, int y, Player player) {
        if (previousMove != null && previousMove.getPlayer().equals(player)) {
            throw new IllegalStateException(String.format("Illegal Move: Player %s us not allowed to move", player.getType().toString()));
        }
        if (isGameOver) {
            throw new IllegalStateException(String.format("Game is over, please start a new game !"));
        }
        if (board.isOccupied(x, y)) {
            throw new IllegalStateException(String.format("Illegal Move: Position (%d,%d) is already occupied!", x, y));
        }
        Position position = new Position(x, y);
        Move currentMove = null;
        try {
            currentMove = new Move(position, player);
        } catch (Exception e) {

        }
        previousMove = currentMove;
        board.update(currentMove);
        gameLogs.addMove(currentMove);
        log.info(String.format("Player %s moved to %s", player.getType().toString(), position.toString()));
        if (board.isWinner(currentMove)) {
            isGameOver = true;
            log.info(String.format("Player %s has won", player.getType().toString()));
            gameLogs.printLogs();
            return player;
        }


        return null;
    }


}
