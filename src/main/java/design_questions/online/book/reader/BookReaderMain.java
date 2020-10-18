package design_questions.online.book.reader;

import com.google.inject.spi.PrivateElements;
import org.junit.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.Optional;

/**
 * @author shivanidwivedi on 16/10/20
 * @project JavaProgramming
 */
public class BookReaderMain {
    private static final String DO_OR_DIE = "DO OR DIE";
    private static final String WINNER = "WINNER";
    private static final String MY_STORY = "MY STORY";
    private static final String FAIL_OR_LEARN = "Fail or Learn";

    public static void main(String[] args) {
        Library library = new Library(new String[]{
                DO_OR_DIE,
                WINNER,
                MY_STORY,
                FAIL_OR_LEARN
        });

        //add users
        UserManager userManager = new UserManager();
        userManager.addUser(1, "Gagan");
        userManager.addUser(2, "Shivani");

        UserActivity shivani = new UserActivity(userManager.findUser(2), library);
        UserActivity gagan = new UserActivity(userManager.findUser(1), library);

        Optional<Book> myBook = shivani.find(FAIL_OR_LEARN);
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

        Optional<Book> gaganBook = gagan.find(DO_OR_DIE);
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
