package design_questions.online.book.reader;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;
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

    @Inject
    public UserActivity(@Named("library") Library library,
                        @Assisted Profile profile) {
        this.profile = profile;
        progress = new Progress(profile);
        this.library = library;

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
