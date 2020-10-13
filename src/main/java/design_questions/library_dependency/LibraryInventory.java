package design_questions.library_dependency;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shivanidwivedi on 12/10/20
 * @project JavaProgramming
 * <p>
 * Available libraries such as Maven.
 * <p>
 * This must be populated in advance
 */
@Data
class LibraryInventory {
    private HashMap<String, Library> libraries;

    public LibraryInventory() {
        libraries = new HashMap<>();
    }


    public boolean addLibrary(String name) {
        Library library = new Library(name);
        if (!libraries.containsKey(name)) {
            libraries.put(name, library);
            return true;
        }
        return false;
    }

    public Library getLibrary(String name) {
        if (libraries.containsKey(name)) {
            return libraries.get(name);
        }
        return null;
    }

    @Override
    public String toString() {
        return "LibraryFactory{" +
                "libraries=" + libraries +
                '}';
    }
}
