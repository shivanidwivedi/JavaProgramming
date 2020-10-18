package design_questions.online.book.reader;

import lombok.Data;

/**
 * @author shivanidwivedi on 16/10/20
 * @project JavaProgramming
 */

@Data
public class Profile {

    private String name;
    private int userId;

    public Profile(int userId, String name){
        this.name = name;
        this.userId = userId;
    }
}
