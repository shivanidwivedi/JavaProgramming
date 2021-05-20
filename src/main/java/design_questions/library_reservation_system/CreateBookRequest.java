package design_questions.library_reservation_system;

import lombok.Builder;
import lombok.Getter;

/**
 * @author shivanidwivedi on 22/03/21
 * @project JavaProgramming
 */

@Builder
@Getter
public class CreateBookRequest {
    private String bookTitle;
    private String subject;
    private String author;
}
