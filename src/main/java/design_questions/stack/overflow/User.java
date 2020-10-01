package design_questions.stack.overflow;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shivanidwivedi on 20/08/20
 * @project JavaProgramming
 */


public class User {
    private Account account;

    @Autowired
    Question question;

    public Question createQuestion(String description){
     //   return Question.builder().build();
        return new Question("yes","hi");
    }
}
