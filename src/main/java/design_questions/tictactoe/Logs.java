package design_questions.tictactoe;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 13/10/20
 * @project JavaProgramming
 */
@Slf4j
public class Logs {
    private List<Move> logs;

    public Logs(){
        logs = new ArrayList<>();
    }

    public void addMove(Move move){
        logs.add(move);
    }

    public void clear() {
        logs.clear();
    }

    public void printLogs(){
        log.info("=====GAME LOGS=====");
        logs.stream().forEach(log -> System.out.println(log.toString()));
    }
}
