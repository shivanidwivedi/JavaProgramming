package design_questions.library_dependency;

import javax.validation.Payload;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author shivanidwivedi on 11/10/20
 * @project JavaProgramming
 */
public class LibraryDependency {
    LibraryInventory libraryInventory;

    public LibraryDependency() {
        this.libraryInventory = new LibraryInventory();
    }

    private static void installLibraries(Library head) {
        Set<Library> installedLibraries = new HashSet<>();
        installLibrary(head, installedLibraries);
    }

    private static Payload installPayLoad(Payload payload) {
        System.out.println("Installing payload");
        return payload;
    }

    static void installLibrary(Library currentLibrary, Set<Library> installedLibraries) {
        if (currentLibrary == null) {
            throw new IllegalArgumentException("Unable to install new library");
        }
        for (Library current : installedLibraries) {
            if (!installedLibraries.contains(currentLibrary)) {
                installLibrary(current, installedLibraries);
            }
        }
        // installPayLoad(currentLibrary.getPayload());
        installedLibraries.add(currentLibrary);
    }

    public static void main(String[] args) {
        LibraryDependency libraryDependency = new LibraryDependency();
        System.out.println("before: " + libraryDependency.libraryInventory);
        libraryDependency.populateLibraries(libraryDependency.libraryInventory);
        libraryDependency.addEdge("junit", "java");
        libraryDependency.addEdge("spring", "java");
        libraryDependency.addEdge("sql", "junit");
        libraryDependency.addEdge("sql", "spring");
        System.out.println("after: " + libraryDependency.libraryInventory);

        Stack<Library> result = TopologicalOrder.order(libraryDependency.libraryInventory.getLibraries().values());
        while (!result.isEmpty()){
            result.pop().install();
        }

    }

    private void populateLibraries(LibraryInventory libraryInventory) {
        libraryInventory.addLibrary("java");
        libraryInventory.addLibrary("junit");
        libraryInventory.addLibrary("spring");
        libraryInventory.addLibrary("sql");
    }

    private void addEdge(String from, String to) {
        if (libraryInventory.getLibraries().containsKey(from)
                && libraryInventory.getLibraries().containsKey(to)) {
            Library fromLib = libraryInventory.getLibraries().get(from);
            Library toLib = libraryInventory.getLibraries().get(to);
            fromLib.dependencies.add(toLib);
        } else {
            throw new IllegalArgumentException("Invalid library names provides");
        }

    }
}

