package design_questions.stack.overflow;


import lombok.Builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shivanidwivedi on 13/08/20
 * @project JavaProgramming
 */

//@Builder
public class Question {
    private String title;
    private String description;
    private int viewCount;
    private int voteCount;
    private Date creationTime;
    private Date updateTime;
    private QuestionStatus status;

    public Question(String title, String description){
        this.title = title;
        this.description = description;
    }

    public List<Comment> getComments(Question question){
        return new ArrayList<>();
    }
}
