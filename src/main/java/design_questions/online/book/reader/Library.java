package design_questions.online.book.reader;

import com.google.inject.Module;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author shivanidwivedi on 16/10/20
 * @project JavaProgramming
 */

@Slf4j
public class Library {
    private HashMap<String, List<Book>> books = new HashMap<>();

    public Library(String[] books) {
        initializeInventory(books);
    }

    public Library() {

    }

    public Optional<Book> find(String title) {
        Optional<Book> myBook = Optional.empty();
        if(books.containsKey(title)) {
            for(Book book : books.get(title)) {
                if(book.isAvailable()) {
                    myBook = Optional.of(book);
                    log.info(String.format("Found the book %s", title));
                    break;
                }
            }
        }
        return myBook;
    }


    private void initializeInventory(String[] books) {
        Arrays.stream(books).forEach(book -> addBook(book));
    }

    public void addBook(String name) {
        String id = UUID.randomUUID().toString();
        Book book = Book.builder().bookName(name).bookId(id).build();
        books.computeIfAbsent(name, list -> new ArrayList<>()).add(book);
        log.info(String.format("Book added \"%s\", new size is %d", name, size()));
    }

    public void deleteBook(String name) {
        if (books.containsKey(name)) {
            for (Book book : books.get(name)) {
                if (book.isAvailable()) {
                    books.get(name).remove(book);
                    log.info(String.format("Book deleted %s, new size is %d", book.getBookName(), size()));
                    return;
                }
            }
        }
        log.error(String.format("Unable to delete book %s", name));
    }

    public int size(){
        int sum = 0;
        for(List<Book> books : books.values()) {
            sum += books.size();
        }
        return sum;
    }
}