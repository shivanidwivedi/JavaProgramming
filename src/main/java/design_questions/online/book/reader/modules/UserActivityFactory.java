package design_questions.online.book.reader.modules;

import design_questions.online.book.reader.Profile;
import design_questions.online.book.reader.UserActivity;

/**
 * @author shivanidwivedi on 18/10/20
 * @project JavaProgramming
 */
public interface UserActivityFactory {
    UserActivity create(Profile profile);
}
