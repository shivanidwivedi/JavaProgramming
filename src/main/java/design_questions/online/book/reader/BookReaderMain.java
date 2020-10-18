package design_questions.online.book.reader;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import design_questions.online.book.reader.modules.LibraryModule;
import design_questions.online.book.reader.modules.UserActivityFactory;
import org.junit.Assert;

import java.util.Optional;

/**
 * @author shivanidwivedi on 16/10/20
 * @project JavaProgramming
 */
public class BookReaderMain {


    public static void main(String[] args) {
        //Main google Guice module loader
        Injector injector = Guice.createInjector(new LibraryModule());

        //UserActivity factory with Guice
        UserActivityFactory factory = injector.getInstance(UserActivityFactory.class);
        UserActivity shivani = factory.create(new Profile(1, "Shivani"));
        UserActivity gagan = factory.create(new Profile(1, "Gagan"));

        //Execution
        Optional<Book> myBook = shivani.find(LibraryModule.FAIL_OR_LEARN);
        Assert.assertTrue(myBook.isPresent());
        Assert.assertFalse("the book is not present in library", shivani.find("invalid").isPresent());
        if (myBook.isPresent()) {
            shivani.startReading(myBook.get());
            Assert.assertEquals(1, shivani.pageIamReading(myBook.get()));
            shivani.nextPage(myBook.get());
            Assert.assertEquals(2, shivani.pageIamReading(myBook.get()));
            shivani.nextPage(myBook.get());
            Assert.assertEquals(3, shivani.pageIamReading(myBook.get()));
            shivani.previousPage(myBook.get());
            shivani.previousPage(myBook.get());
            Assert.assertEquals(1, shivani.pageIamReading(myBook.get()));
            shivani.displayProgress();
        }

        Optional<Book> gaganBook = gagan.find(LibraryModule.DO_OR_DIE);
        Assert.assertTrue(gaganBook.isPresent());
        Assert.assertFalse(gagan.find("Gagan comes second").isPresent());
        if (gaganBook.isPresent()) {
            gagan.startReading(gaganBook.get());
            gagan.nextPage(gaganBook.get());
            gagan.nextPage(gaganBook.get());
            gagan.displayProgress();
        }

    }
}
