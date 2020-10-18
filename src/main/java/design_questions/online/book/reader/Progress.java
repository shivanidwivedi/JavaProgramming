package design_questions.online.book.reader;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shivanidwivedi on 17/10/20
 * @project JavaProgramming
 */
@Slf4j
@ToString
@Getter
public class Progress {
    private Map<Book, Integer> progress;
    private Profile userProfile;

    public Progress(Profile profile) {
        userProfile = profile;
        progress = new HashMap<>();
    }
    public boolean addBook(Book book) {
        progress.put(book, 1);
        return true;
    }

    public int page(Book book) {
        if(progress.containsKey(book)) {
            return progress.get(book);
        }
        return -1;
    }

    public boolean markComplete(Book book) {
        if(!isBeingRead(book)) {
            log.error(String.format("Aborting. %s has not started book %s yet.", userProfile.getName(),book.getTitle()));
            return false;
        }
        progress.put(book, book.getTotalPages());
        return true;
    }

    public boolean next(Book book) {
        if(!isBeingRead(book)) {
            log.info("Starting to read book");
            addBook(book);
            return true;
        }
        next(book, 1);
        return true;
    }

    private boolean isBeingRead(Book book) {
        if(progress.containsKey(book)) {
            return true;
        }
        return false;
    }

    public boolean next(Book book, int pageNumber) {
        int nextPage = progress.get(book)+pageNumber;
        if(book.isValidPage(nextPage)) {
            log.info(String.format("%s flipped page of book %s from %d to %d",userProfile.getName(),
                    book.getTitle(), progress.get(book), nextPage));
            progress.put(book, nextPage);
            return true;
        }
        log.error(String.format("No next page available %s. book is already finished.",pageNumber));
        return false;
    }

    public boolean previous(Book book){
        next(book, -1);
        return true;
    }

    public boolean previous(Book book, int page){
        next(book, page);
        return true;
    }
}
