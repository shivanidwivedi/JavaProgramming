package design_questions.library_reservation_system;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author shivanidwivedi on 22/03/21
 * @project JavaProgramming
 */

@Data
public class Book {
    private String bookTitle;
    private String bookId;
    private String author;
    private String subject;


}
