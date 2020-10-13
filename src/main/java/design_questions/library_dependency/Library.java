package design_questions.library_dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Library class : which represents a single library structure.
 * Each library has a name and a list of its dependencies
 */
class Library implements Comparable<Library> {
    String name;
    boolean isInstalled;
    // private Payload payload;
    /**
     * all the dependencies should be installed before this library
     */
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
                // ", payload=" + payload +
                ", dependencies=" + getLibraryList() +
                '}';
    }

    private String getLibraryList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        this.dependencies.stream().forEach(dependency -> stringBuilder.append(dependency.name+","));
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public void install() {
        this.dependencies.stream().forEach(d -> {
            if(!d.isInstalled) {
                throw new IllegalStateException("please install "+name +"'s dependency: "+d.name);
            }
        });
        System.out.println("Installing "+name);
        isInstalled = true;
    }


    @Override
    public int compareTo(Library o) {
        return this.name.compareTo(o.name);
    }
}
