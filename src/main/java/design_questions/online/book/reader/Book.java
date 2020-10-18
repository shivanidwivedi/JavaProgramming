package design_questions.online.book.reader;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author shivanidwivedi on 16/10/20
 * @project JavaProgramming
 */

@Getter
@Builder
@ToString
public class Book {

    private String bookName;
    private String bookId;
    private final int totalPages = 100;
    private boolean notAvailable;

    public void borrow() {
        notAvailable = true;
    }

    public boolean isAvailable() {
        return !notAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookName.equals(book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }

    public boolean isValidPage(int page) {
        if (page < 0 && page > totalPages) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return "\"" + this.bookName + "\"";
    }
}
