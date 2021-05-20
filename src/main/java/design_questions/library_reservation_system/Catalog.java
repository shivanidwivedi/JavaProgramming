package design_questions.library_reservation_system;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shivanidwivedi on 22/03/21
 * @project JavaProgramming
 */

@Getter
public class Catalog implements Search{
    private Map<String, List<Book>> bookTitles;
    private Map<String, List<Book>> bookAuthors;
    private Map<String, List<Book>> bookSubjects;
    @Override
    public List<Book> searchByTitle(String title) throws Exception {
        if(!bookTitles.containsKey(title)){
            throw new Exception("Book with this title not found");
        }
        return bookTitles.get(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) throws Exception {
        if(!bookAuthors.containsKey(author)){
            throw new Exception("Book with the author not found");
        }
        return bookAuthors.get(author);
    }

    @Override
    public List<Book> searchBySubject(String subject) throws Exception {
        if(!bookSubjects.containsKey(subject)){
            throw  new Exception("Book with this subject not found");
        }
        return bookSubjects.get(subject);
    }

    public void addBook(Book book){
        if (!bookTitles.containsKey(book.getBookTitle())){
            bookTitles.put(book.getBookTitle(), new ArrayList<>());
        }
        bookTitles.get(book.getBookTitle()).add(book);

        if (!bookAuthors.containsKey(book.getAuthor())){
            bookAuthors.put(book.getAuthor(), new ArrayList<>());
        }
        bookAuthors.get(book.getAuthor()).add(book);

        if (!bookSubjects.containsKey(book.getSubject())){
            bookSubjects.put(book.getSubject(), new ArrayList<>());
        }
        bookSubjects.get(book.getSubject()).add(book);
    }
}
