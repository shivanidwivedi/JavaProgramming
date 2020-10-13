package design_questions.library_dependency;

import java.util.*;

/**
 * @author shivanidwivedi on 12/10/20
 * @project JavaProgramming
 */
public class TopologicalOrder {

    public static Stack<Library> order(Collection<Library> packages) {
        Stack<Library> libraries = correctOrdering(packages);
        Collections.reverse(libraries);
        return libraries;
    }

    private static Stack<Library> correctOrdering(Collection<Library> packages){
        Stack<Library> stack = new Stack<>();
        HashSet<Library> visited = new HashSet<>();
        for (Library library : packages ){
            if(!visited.contains(library)){
                correctOrderingHelper(library,visited,stack);
            }
        }
        return stack;
    }

    private static void correctOrderingHelper(Library library, HashSet<Library> visited, Stack<Library> stack){
        visited.add(library);
        Library currentLibrary;

       // library.dependencies.stream().forEach(dep -> );
        Iterator<Library> iterator = library.dependencies.iterator();
        while (iterator.hasNext()){
            currentLibrary = iterator.next();
            if(!visited.contains(currentLibrary))
                correctOrderingHelper(currentLibrary, visited, stack);
        }
        stack.push(library);
    }


}
