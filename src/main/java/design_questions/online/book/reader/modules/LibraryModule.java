package design_questions.online.book.reader.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import design_questions.online.book.reader.Library;
import design_questions.online.book.reader.UserActivity;

/**
 * @author shivanidwivedi on 18/10/20
 * @project JavaProgramming
 */
public class LibraryModule extends AbstractModule {
    public static final String DO_OR_DIE = "DO OR DIE";
    public static final String WINNER = "WINNER";
    public static final String MY_STORY = "MY STORY";
    public static final String FAIL_OR_LEARN = "Fail or Learn";
    @Override
    protected void configure() {
        //bind library object
        bind(Library.class)
                .annotatedWith(Names.named("library"))
                .toProvider(new LibraryProvider()).in(Singleton.class);

        //user activity
        /**
         * Why factory for use activity ?
         * UserActivities can be multiple - one for each user.
         *
         * The following Guice built in implementation of factory pattern saves us from
         * creating factory classes and takes care of it out of the box.
         * Note that you MUST use @Assisted in UserActivity constructor for the parameter
         * that will be passed dynamically such as Profile.
         */
       install(new FactoryModuleBuilder()
               .build(UserActivityFactory.class));

        bindInterceptor(Matchers.any(),
                Matchers.annotatedWith(CallTracker.class),
                new LoggingInterceptor());
    }
}

/**
 * Provides Library object
 */
class LibraryProvider implements Provider<Library> {

    @Override
    public Library get() {
        return new Library(new String[]{
                LibraryModule.DO_OR_DIE,
                LibraryModule.WINNER,
                LibraryModule.MY_STORY,
                LibraryModule.FAIL_OR_LEARN
        });
    }
}
