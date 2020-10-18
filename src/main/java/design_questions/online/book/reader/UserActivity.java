package design_questions.online.book.reader;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author shivanidwivedi on 17/10/20
 * @project JavaProgramming
 */
@Slf4j
public class UserActivity {
    private Profile profile;
    private Progress progress; //user book history
    private Library library;

    public UserActivity(Profile profile, Library library) {
        this.profile = profile;
        this.library = library;
        progress = new Progress(profile);

    }

    public boolean startReading(Book book) {
        progress.addBook(book);
        log.info(String.format("%s started reading book %s",profile.getName(), book.getTitle()));
        return true;
    }


    public Optional<Book> find(String title) {
        Optional<Book> book = library.find(title);
        if(book.isPresent()) {
            return book;
        }
        log.error(String.format("Not able to find book with name %s", title));
        return book;
    }

    public boolean complete(Book book) {
        progress.markComplete(book);
        return true;
    }

    public boolean nextPage(Book book) {
        progress.next(book);
        return true;
    }

    public boolean previousPage(Book book) {
        progress.previous(book);
        return true;
    }

    public int pageIamReading(Book book) {
        return progress.page(book);
    }

    public void displayProgress() {
        log.info(progress.toString());
    }
}
