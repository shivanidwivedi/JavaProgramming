package design_questions.stack.overflow;

import lombok.Builder;

import java.util.Date;
import java.util.List;

/**
 * @author shivanidwivedi on 13/08/20
 * @project JavaProgramming
 */

@Builder
public class Answer {
    private String answerText;
    private boolean accepted;
    private Date creationTime;
    private Date updateTime;
    private int voteCount;
    private int flagCount;

    public void incrementFlagCount(){

    }
}
