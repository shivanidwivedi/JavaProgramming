package design_questions.library_reservation_system;

import java.util.List;

/**
 * @author shivanidwivedi on 22/03/21
 * @project JavaProgramming
 */
public interface Search {
    public List<Book> searchByTitle(String title) throws Exception;
    public List<Book> searchByAuthor(String author) throws Exception;
    public List<Book> searchBySubject(String subject) throws Exception;
}
