package design_questions;

import lombok.Builder;
import lombok.Data;

import javax.validation.Payload;
import java.util.*;

/**
 * @author shivanidwivedi on 11/10/20
 * @project JavaProgramming
 */
public class LibraryDependency {
    LibraryContainer libraryContainer;

    public LibraryDependency() {
        this.libraryContainer = new LibraryContainer();
    }
    private static void installLibraries(Library head){
        Set<Library> installedLibraries = new HashSet<>();
        installLibrary(head, installedLibraries);
    }
    private static Payload installPayLoad(Payload payload){
        System.out.println("Installing payload");
        return payload;
    }

    static void installLibrary(Library currentLibrary, Set<Library> installedLibraries){
        if(currentLibrary == null){
            throw new IllegalArgumentException("Unable to install new library");
        }
        for(Library current : installedLibraries){
            if(!installedLibraries.contains(currentLibrary)){
                installLibrary(current, installedLibraries);
            }
        }
       // installPayLoad(currentLibrary.getPayload());
        installedLibraries.add(currentLibrary);
    }

    public static void main(String[] args) {
        LibraryDependency libraryDependency = new LibraryDependency();
        System.out.println("before: "+libraryDependency.libraryContainer);
        libraryDependency.addEdge("java","junit");
        System.out.println("after: "+libraryDependency.libraryContainer);

    }

    private void addEdge(String from, String to) {
        if(libraryContainer.getLibraries().containsKey(from)
                && libraryContainer.getLibraries().containsKey(to)) {
            Library fromLib = libraryContainer.getLibraries().get(from);
            Library toLib = libraryContainer.getLibraries().get(to);
            fromLib.dependencies.add(toLib);
        } else {
            throw new IllegalArgumentException("Invalid library names provides");
        }

    }


}

@Data
class LibraryContainer {
    private Map<String, Library> libraries;

    public LibraryContainer() {
        libraries = new HashMap<>();
        libraries.put("java", new Library("java"));
        libraries.put("junit", new Library("junit"));
    }

    @Override
    public String toString() {
        return "LibraryContainer{" +
                "libraries=" + libraries +
                '}';
    }
}

class Library{
    private String name;
    private Payload payload;
    List<Library> dependencies;

    public Library(String name) {
        this.name = name;
        dependencies = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", payload=" + payload +
                ", dependencies=" + dependencies +
                '}';
    }
}